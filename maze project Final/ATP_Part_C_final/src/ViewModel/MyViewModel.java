package ViewModel;
//import  java.util.*;
import Model.IModel;
import Model.MyModel;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import  javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.util.Duration;



public class MyViewModel extends Observable implements Observer {
    public Solution solution;
    private IModel model;
    private Maze maze;
    private int characterPositionRowIndex;
    private int characterPositionColumnIndex;
    public MediaPlayer mediaPlayer;


    public Media gameSong;
//    public StringProperty characterPositionRow = new SimpleStringProperty("1"); //For Binding
//    public StringProperty characterPositionColumn = new SimpleStringProperty("1"); //For Binding



    public int getCharacterPositionRowIndex() {
        return characterPositionRowIndex;
    }

    public int getCharacterPositionColumnIndex() {
        return characterPositionColumnIndex;
    }
    public Maze getMaze() {
        return model.getMaze();
    }

    public int getCharacterPositionRow() {
        return characterPositionRowIndex;
    }

    public int getCharacterPositionColumn() {
        return characterPositionColumnIndex;
    }

    public MyViewModel(IModel model){
        this.model = model;
        //this.model.assignObserver(this);
    }

    public Solution getSolution(){
       // MyModel m = (MyModel)model;
       return model.getSolution();
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o == model){
            solution =model.getSolution();
            //Maze maze= model.getMaze();
            this.characterPositionRowIndex=model.getCharacterPositionRow();
//            characterPositionRow.set(characterPositionRow+"");

            this.characterPositionColumnIndex=model.getCharacterPositionColumn();
//            characterPositionColumn.set(characterPositionColumn+"");
            }
            setChanged();
            notifyObservers(arg);

//            characterPositionRowIndex = model.getCharacterPositionRow();
//            characterPositionRow.set(characterPositionRowIndex + "");
//            characterPositionColumnIndex = model.getCharacterPositionColumn();
//            characterPositionColumn.set(characterPositionColumnIndex + "");
//            setChanged();
//            notifyObservers();
        }


        public  void solveMaze(){
        model.solveMaze();
        }
    public void generateMaze(int rows, int cols){
        this.solution=null;
        model.generateMaze(rows, cols);
    }

    public  void exitGame(){
        model.exitGame();
    }

    public void saveGame(File path) {
        model.saveGame(path);
    }

    public void Load(File path) {
        model.Load(path);
    }
}
