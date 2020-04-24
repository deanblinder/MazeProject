package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    /**
     *
     * @param row number of rows in maze
     * @param col number of columns in maze
     * @return maze full of zeros
     */
    public Maze generate(int row, int col) {
        Maze m = new Maze(row, col);
        return m;
    }
}
