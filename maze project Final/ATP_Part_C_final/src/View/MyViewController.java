package View;

import Server.Configurations;
import ViewModel.MyViewModel;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.ResourceBundle;


public class MyViewController implements Observer, IView, Initializable {
    private MyViewModel myViewModel;
    public Stage theStage;
    public Scene scene;
    @FXML
    public  Button btn_solveButton;
    @FXML
    public MazeDisplayer mazeDisplayer;
    public  Solution solution;
    public TextField txtfld_rowsNum;
    public TextField txtfld_columnsNum;
    public Label lbl_rowsNum;
    public Label lbl_columnsNum;
    public Button btn_generateMaze;
   // public Button btn_solveButton;
    public Label lbl_player_row;
    public Label lbl_player_col;
    public Slider lbl_numOfTreads;
    public Timeline timeline = new Timeline(60);
    public  BorderPane borderPane;
    public  boolean isMazeExist = true;
    public CheckMenuItem Simple;
    public CheckMenuItem MyGenerator;
    public CheckMenuItem Empty;


    StringProperty update_player_position_row = new SimpleStringProperty();
    StringProperty update_player_position_col = new SimpleStringProperty();
public  void setStage(Stage stage){
    this.theStage=stage;
}

public  Button getBtn(){
    return btn_solveButton;
}
    public void setResizeEvent(Scene scene) {

        if (isMazeExist){
            scene.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                   mazeDisplayer.setWidth(theStage.getWidth()-200);
                    mazeDisplayer.redraw();
                }
            });
            scene.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                    mazeDisplayer.setHeight(theStage.getHeight()-100);
                    mazeDisplayer.redraw();
                }
            });
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mazeDisplayer.setMyViewController(this);
        this.myViewModel=myViewModel;
       // this.theStage =stage;
        this.scene=scene;



        lbl_player_row.textProperty().bind(update_player_position_row);
        lbl_player_col.textProperty().bind(update_player_position_col);
    }
    public String getUpdate_player_position_row() {
        return update_player_position_row.get();
    }
    public StringProperty update_player_position_rowProperty() {
        return update_player_position_row;
    }
    public CheckMenuItem bestOption;
    public CheckMenuItem depthOption;
    public CheckMenuItem breadthOption;

    public void pickNumOfTreads(){

        int num = (int) lbl_numOfTreads.getValue();
        System.out.println(num);
        Configurations.setNumOfThreadsConfiguration(num);
    }
    public void pickBfs() {
        Configurations.setConfiguration("searchAlgo","BreadthFirstSearch");

        breadthOption.setSelected(true);
        depthOption.setSelected(false);
        bestOption.setSelected(false);
    }

    public void pickDfs() {
        Configurations.setConfiguration("searchAlgo","DepthFirstSearch");
        breadthOption.setSelected(false);
        depthOption.setSelected(true);
        bestOption.setSelected(false);
    }

    public void pickBest() {
        Configurations.setConfiguration("searchAlgo","BestFirstSearch");
        breadthOption.setSelected(false);
        depthOption.setSelected(false);
        bestOption.setSelected(true);
    }



    public void pickSimple() {
        Configurations.setConfiguration("generator","simple");
        Simple.setSelected(true);
        MyGenerator.setSelected(false);
        Empty.setSelected(false);
    }

    public void pickMyMaze() {
        Configurations.setConfiguration("generator","SimpleMazeGenerator");
        Simple.setSelected(false);
        MyGenerator.setSelected(true);
        Empty.setSelected(false);
    }

    public void pickEmpty() {
        Configurations.setConfiguration("generator","empty");
        Simple.setSelected(false);
        MyGenerator.setSelected(false);
        Empty.setSelected(true);
    }

    public void onScroll(ScrollEvent scroll) {
        double zoomScale;
        if (scroll.isControlDown()) {
            zoomScale = 1.5;
            double deltaY = scroll.getDeltaY();
            if(deltaY < 0){
                zoomScale = 1/ zoomScale;
            }
            zoom(mazeDisplayer, zoomScale, scroll.getSceneX(), scroll.getSceneY());
            mazeDisplayer.setScaleX(mazeDisplayer.getScaleX() * zoomScale);
            mazeDisplayer.setScaleY(mazeDisplayer.getScaleY() * zoomScale);
            scroll.consume();
        }
    }

    void zoom(Node node, double factor, double x, double y) {
        double oldScale = node.getScaleX();
        double scale = oldScale * factor;
        double f = (scale / oldScale) - 1;

        Bounds bounds = node.localToScene(node.getLayoutBounds(), true);
        double dx = (x-(bounds.getWidth() / 2+bounds.getMinX()));
        double dy = (y-(bounds.getHeight() / 2+bounds.getMinY()));

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100), new KeyValue(node.translateXProperty(), node.getTranslateX()-f * dx)),
                new KeyFrame(Duration.millis(100), new KeyValue(node.translateYProperty(), node.getTranslateY()-f * dy)),
                new KeyFrame(Duration.millis(100), new KeyValue(node.scaleXProperty(), scale)),
                new KeyFrame(Duration.millis(100), new KeyValue(node.scaleYProperty(), scale))
        );
        timeline.play();
    }

    public void initialize(MyViewModel myViewModel,Stage stage,Scene scene) {
        lbl_player_row.textProperty().bind(update_player_position_row);
        lbl_player_col.textProperty().bind(update_player_position_col);
        this.myViewModel=myViewModel;
        this.theStage =stage;
        this.scene=scene;
        //create music element


    }
    public void setUpdate_player_position_row(String update_player_position_row) {
        this.update_player_position_row.set(update_player_position_row);
    }
    public String getUpdate_player_position_col() {
        return update_player_position_col.get();
    }
    public StringProperty update_player_position_colProperty() {
        return update_player_position_col;
    }
    public void setUpdate_player_position_col(String update_player_position_col) {
        this.update_player_position_col.set(update_player_position_col);
    }
    public void setMyViewModel(MyViewModel myViewModel) {
        this.myViewModel = myViewModel;
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o == myViewModel) {
            displayMaze(myViewModel.getMaze());
            btn_generateMaze.setDisable(false);
            mazeDisplayer.showSolution(myViewModel.getSolution());
          //  mazeDisplayer.markPath();
        }
    }
    @Override
    public void displayMaze(Maze maze) {
        mazeDisplayer.setMaze(maze);
        int characterPositionRow = myViewModel.getCharacterPositionRow();
        int characterPositionColumn = myViewModel.getCharacterPositionColumn();
        mazeDisplayer.setCharacterPosition(characterPositionRow, characterPositionColumn);
        this.characterPositionRow.set(characterPositionRow + "");
        this.characterPositionColumn.set(characterPositionColumn + "");
    }

    public void markPath(){
        mazeDisplayer.showSolution(solution);
    }

    public  void  solveMaze(){
        myViewModel.solveMaze();
        solution = myViewModel.getSolution();

        markPath();
    }

    public  Solution  getSolution(){///check

       return myViewModel.getSolution();
    }


    public void generateMaze() {
        isMazeExist = true;
        mazeDisplayer.setSol(null);
        btn_solveButton.setDisable(false);
        int rows = Integer.valueOf(txtfld_rowsNum.getText());
        int cols = Integer.valueOf(txtfld_columnsNum.getText());
        while ((rows<2 || cols<2)||(rows>999 || cols>999)){
            Alert alert = new Alert(Alert.AlertType.ERROR,"please enter number between 2-999");
            alert.showAndWait();
            return;
        }
        mazeDisplayer.startMusic(true);

        myViewModel.generateMaze(rows, cols);
    }

    public void showAlert(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();
    }
    public boolean isLegalMove(int row,int col){
        int height = Integer.valueOf(txtfld_rowsNum.getText());
        int width = Integer.valueOf(txtfld_columnsNum.getText());
        if(((row>=0 && row<height) && (col>=0 && col<width))&& (mazeDisplayer.getCellValue(row,col)==0)){
            return true;
        }
        else{
            return false;
        }
    }
    public void KeyPressed(KeyEvent keyEvent) {

        int player_row_position = mazeDisplayer.getCharacterPositionRow();
        int player_col_position = mazeDisplayer.getCharacterPositionColumn();
        switch (keyEvent.getCode()){
            case NUMPAD8:
                if(isLegalMove(player_row_position-1,player_col_position)){
                    mazeDisplayer.setCharacterPosition(player_row_position-1,player_col_position);
                    setUpdate_player_position_row(player_row_position-1+"");
                    setUpdate_player_position_col(player_col_position+"");
                }
                break;
            case NUMPAD2:
                if(isLegalMove(player_row_position+1,player_col_position)){
                    mazeDisplayer.setCharacterPosition(player_row_position+1,player_col_position);
                    setUpdate_player_position_row(player_row_position+1+"");
                    setUpdate_player_position_col(player_col_position+"");
                }
                break;
            case NUMPAD6:
                if(isLegalMove(player_row_position,player_col_position+1)){
                    mazeDisplayer.setCharacterPosition(player_row_position,player_col_position+1);
                    setUpdate_player_position_row(player_row_position+"");
                    setUpdate_player_position_col(player_col_position+1+"");
                }
                break;
            case NUMPAD4:
                if(isLegalMove(player_row_position,player_col_position-1)){
                    mazeDisplayer.setCharacterPosition(player_row_position,player_col_position-1);
                    setUpdate_player_position_row(player_row_position+"");
                    setUpdate_player_position_col(player_col_position-1+"");
                }
                break;
            case NUMPAD7://left up
                if(isLegalMove(player_row_position-1,player_col_position-1)){
                    mazeDisplayer.setCharacterPosition(player_row_position-1,player_col_position-1);
                    setUpdate_player_position_row(player_row_position-1+"");
                    setUpdate_player_position_col(player_col_position-1+"");
                }

                break;
            case NUMPAD9://right Up
                if(isLegalMove(player_row_position-1,player_col_position+1))
                {
                    mazeDisplayer.setCharacterPosition(player_row_position-1,player_col_position+1);
                    setUpdate_player_position_row(player_row_position-1+"");
                    setUpdate_player_position_col(player_col_position+1+"");
                }
                break;
            case NUMPAD1://left down
                if(isLegalMove(player_row_position+1,player_col_position-1)){
                    mazeDisplayer.setCharacterPosition(player_row_position+1,player_col_position-1);
                    setUpdate_player_position_row(player_row_position+1+"");
                    setUpdate_player_position_col(player_col_position-1+"");
                }

                break;
            case NUMPAD3://right down
                if(isLegalMove(player_row_position+1,player_col_position+1)){
                    mazeDisplayer.setCharacterPosition(player_row_position+1,player_col_position+1);
                    setUpdate_player_position_row(player_row_position+1+"");
                    setUpdate_player_position_col(player_col_position+1+"");
                }

                break;
            default:
                mazeDisplayer.setCharacterPosition(player_row_position,player_col_position);
                setUpdate_player_position_row(player_row_position+"");
                setUpdate_player_position_col(player_col_position+"");
        }
        keyEvent.consume();
    }

    //region String Property for Binding
    public StringProperty characterPositionRow = new SimpleStringProperty();

    public StringProperty characterPositionColumn = new SimpleStringProperty();

    public String getCharacterPositionRow() {
        return characterPositionRow.get();
    }

    public StringProperty characterPositionRowProperty() {
        return characterPositionRow;
    }

    public String getCharacterPositionColumn() {
        return characterPositionColumn.get();
    }

    public StringProperty characterPositionColumnProperty() {
        return characterPositionColumn;
    }

//    public void setResizeEvent(Scene scene) {
//        long width = 0;
//        long height = 0;
//        scene.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
//                System.out.println("Width: " + newSceneWidth);
//            }
//        });
//        scene.heightProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
//                System.out.println("Height: " + newSceneHeight);
//            }
//        });
//    }

    public void saveGame(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File path = fileChooser.showSaveDialog(theStage);
        myViewModel.saveGame(path);
    }
    public void loadGame(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("(*.maze)","*.maze");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Open File");
        File path = fileChooser.showOpenDialog(theStage);
        myViewModel.Load(path);
        mazeDisplayer.showSolution(myViewModel.getSolution());
    }

    public  void  showProperties(){
        try {
            Stage stage = new Stage();
            stage.setTitle("Properties");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Properties.fxml").openStream());
            Scene scene = new Scene(root, 400, 350);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  exitGame(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"are you sure you want to exit?");
        Optional<ButtonType> ans = alert.showAndWait();
        if(ans.get()==ButtonType.OK){
            myViewModel.exitGame();
            theStage.close();
        }
        else if(ans.get() == ButtonType.CANCEL) {
            alert.close();
        }
    }

    public void About(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            stage.setTitle("AboutController");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("About.fxml").openStream());
            Scene scene = new Scene(root, 400, 350);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showHelp(ActionEvent actionEvent) {
        try {
            Stage helpStage = new Stage();
            helpStage.setTitle("AboutController");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("Help.fxml").openStream());
            Scene scene = new Scene(root, 600, 500);
            helpStage.setScene(scene);
            helpStage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            helpStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        this.mazeDisplayer.requestFocus();
    }




    //endregion

}
