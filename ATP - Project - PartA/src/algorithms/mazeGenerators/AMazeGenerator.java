package algorithms.mazeGenerators;
public abstract class AMazeGenerator implements IMazeGenerator {


    public long measureAlgorithmTimeMillis(int row,int col){
       long start = System.currentTimeMillis();
       generate(row,col);
       long end = System.currentTimeMillis();
       return (end-start);
    }
    public Maze generate(int row,int col) {

        return null;
    }
}
