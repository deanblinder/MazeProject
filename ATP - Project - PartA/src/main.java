import algorithms.mazeGenerators.*;
public class main {
//    public static void main(){


    public static void main(String[] args) {
        MyMazeGenerator maze= new MyMazeGenerator();
//        Maze PrintMaze=maze.generate(10,10);
//        PrintMaze.print();
//        System.out.println("start "+PrintMaze.getStartPosition().toString());
//        System.out.println("end "+PrintMaze.getGoalPosition().toString());
        //System.out.println(PrintMaze.getEndPosition());
        long time = maze.measureAlgorithmTimeMillis(1000,1000);
        System.out.println(Math.pow(10,-9)*time);
        System.out.println(time);

    }
}
