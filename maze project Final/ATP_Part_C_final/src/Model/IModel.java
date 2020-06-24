package Model;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.Observer;


public interface IModel {
    public void generateMaze(int rows, int cols);
    public void moveCharacter(KeyCode movement);
    public Maze getMaze();
    public int getCharacterPositionRow();
    public  int getCharacterPositionColumn();
    public void  assignObserver(Observer o);
    public  void solveMaze();
    public Solution getSolution();
    public void exitGame();

    void saveGame(File path);

    void Load(File path);


}
