package algorithms.mazeGenerators;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;

public class EmptyMazeGenerator extends AMazeGenerator {
    public Maze generate(int row, int col) {
        Maze m = new Maze(row, col);
        return m;
    }
}
