package View;

import Model.MyModel;
import algorithms.mazeGenerators.Maze;
import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.Solution;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MazeDisplayer extends Canvas {
    private Maze maze;
    private MyModel model;



    Solution sol ;
    private int characterPositionRow = 1;
    private int characterPositionColumn = 1;
    private StringProperty ImageFileNameWall = new SimpleStringProperty();
    private StringProperty ImageFileNameCharacter = new SimpleStringProperty();
    private StringProperty ImageFileNameGoal = new SimpleStringProperty();
    private StringProperty imageFileNameGoal = new SimpleStringProperty();
    MyViewController myViewController ;
    boolean isSolved=false;

    public void setMaze(Maze maze) {
        this.maze = maze;
        //redraw();
    }
    public void setMyViewController(MyViewController myCon){
        this.myViewController=myCon;
    }
    public int getCellValue(int row,int col){
//        for(int i=0;i<maze.getRow();i++){
//            for(int j=0;j<maze.getCol();j++){
//                System.out.print(maze.getCellValue(i,j)+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------------");
        return maze.getCellValue(row,col);
    }
    public void setCharacterPosition(int row, int column) {
        characterPositionRow = row;
        characterPositionColumn = column;
       redraw();
    }

    public int getCharacterPositionRow() {
        return characterPositionRow;
    }

    public int getCharacterPositionColumn() {
        return characterPositionColumn;
    }

    public void setCharacterPosition(int characterPositionRow) {
        this.characterPositionRow = characterPositionRow;
    }

    public void setCharacterPositionColumn(int characterPositionColumn) {
        this.characterPositionColumn = characterPositionColumn;
    }
    public void showSolution(Solution sol){
        this.sol=sol;
        markPath();
    }
    public MediaPlayer mediaPlayer;
    public Media gameSong;

    public void startMusic(boolean flag) {
        if(mediaPlayer !=null){
            mediaPlayer.stop();
//            mediaPlayer.pause();
        }
        if(flag==true){
            String musicFile = "resources/music/gameSong.mp3";
            gameSong = new Media(new File(musicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(gameSong);
           mediaPlayer.play();
        }
        else{
            String musicFile = "resources/music/winner.mp3";
            gameSong = new Media(new File(musicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(gameSong);
           mediaPlayer.play();
        }

    }

    public void markPath(){

        if(this.sol!=null) {
            // sol=model.getSolution();
            GraphicsContext gc = getGraphicsContext2D();
            double canvasHeight = getHeight();
            double canvasWidth = getWidth();
            double cellHeight = canvasHeight / maze.getRow();
            double cellWidth = canvasWidth / maze.getCol();
            int[][] ans = new int[sol.getSolutionPath().size()][2];
            gc.setFill(Color.RED);
            ArrayList<AState> arrAstate = sol.getSolutionPath();
            for (int i = 1; i < arrAstate.size()-1; i++) {
                ans[i][0] = (((MazeState) (arrAstate.get(i))).getPosition().getRowIndex());
                ans[i][1] = (((MazeState) (arrAstate.get(i))).getPosition().getColumnIndex());
                gc.fillRect(ans[i][1] * cellWidth,ans[i][0] * cellHeight,cellWidth,cellHeight);
            }
        }
    }
    public void setMazeSolution(Solution sol) {
        this.sol = sol;
    }
    public void redraw() {
        if (maze != null) {
            double canvasHeight = getHeight();
            double canvasWidth = getWidth();
            double cellHeight = canvasHeight / maze.getRow();
            double cellWidth = canvasWidth / maze.getCol();
            try {
                Image wallImage = new Image(new FileInputStream(ImageFileNameWall.get()));
                Image characterImage = new Image(new FileInputStream(ImageFileNameCharacter.get()));
                Image goalImage = new Image(new FileInputStream(imageFileNameGoal.get()));
                GraphicsContext gc = getGraphicsContext2D();
                gc.clearRect(0, 0, getWidth(), getHeight());
                for (int i = 0; i < maze.getRow(); i++) {
                    for (int j = 0; j < maze.getCol(); j++) {
                        if(characterPositionColumn==maze.getGoalPosition().getColumnIndex()&&characterPositionRow==maze.getGoalPosition().getRowIndex()){
                            startMusic(false);
                            myViewController.getBtn().setDisable(true);
                            showWinnerAlert("winner");
                            return;
                        }

                        if (maze.getCellValue(i,j) == 1) {
                            gc.drawImage(wallImage, j * cellWidth, i * cellHeight, cellWidth, cellHeight);

                        }
                        if(i==maze.getGoalPosition().getRowIndex()&&j==maze.getGoalPosition().getColumnIndex()){
                            gc.drawImage(goalImage,j * cellWidth , i * cellHeight, cellWidth, cellHeight);
                        }

                    }
                }
                markPath();
//                System.out.println("start pos"+maze.getStartPosition().toString());
//                System.out.println("end pos"+maze.getGoalPosition().toString());
                gc.drawImage(characterImage, characterPositionColumn * cellWidth , characterPositionRow * cellHeight ,cellWidth, cellHeight);




            } catch (FileNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }
    public Solution getSol() {
        return sol;
    }

    public void setSol(Solution sol) {
        this.sol = sol;
    }
    public void showWinnerAlert(String s) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, s, ButtonType.OK);
        alert.showAndWait();
    }
    public String getImageFileNameWall() {
        return ImageFileNameWall.get();
    }
    public void setImageFileNameWall(String imageFileNameWall) {
        this.ImageFileNameWall.set(imageFileNameWall);
    }

    public String getImageFileNameCharacter() {
        return ImageFileNameCharacter.get();
    }

    public String getImageFileNameGoal() {
        return imageFileNameGoal.get();
    }

    public void setImageFileNameGoal(String imageFileNameGoal) {
        this.imageFileNameGoal.set(imageFileNameGoal);
    }
    public StringProperty imageFileNameGoalProperty() {
        return imageFileNameGoal;
    }

    public void setImageFileNameCharacter(String imageFileNameCharacter) {
        this.ImageFileNameCharacter.set(imageFileNameCharacter);
    }
    //endregion

}
