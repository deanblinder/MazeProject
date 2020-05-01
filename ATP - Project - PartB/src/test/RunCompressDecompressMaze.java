package test;
import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.*;
public class RunCompressDecompressMaze {
    public static void main(String[] args) {

//       byte[] b = ByteBuffer.allocate(4).putInt(4).array();
//        byte[] b1 = ByteBuffer.allocate(4).putInt(8).array();
//        byte[] b2 = ByteBuffer.allocate(4).putInt(2).array();


      //  System.out.println(b);
       // Position pos = new Position(ByteBuffer.wrap(b).getInt(),ByteBuffer.wrap(b).getInt());


        String mazeFileName = "savedMaze.maze";
        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(3, 3); //Generate new maze
       byte[] temp = maze.convertToBinary(15);

        maze.print();//
        try {
            // save maze to a file
            OutputStream out = new MyCompressorOutputStream(new
                    FileOutputStream(mazeFileName));
            System.out.println(Arrays.toString(maze.toByteArray()));//
            out.write(maze.toByteArray());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte savedMazeBytes[] = new byte[0];
        try {
            //read maze from file
            InputStream in = new MyDecompressorInputStream(new
                    FileInputStream(mazeFileName));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Maze loadedMaze = new Maze(savedMazeBytes);
        maze.print();
        System.out.println();
        loadedMaze.print();
        boolean areMazesEquals =
                Arrays.equals(loadedMaze.toByteArray(),maze.toByteArray());
        System.out.println(String.format("Mazes equal: %s",areMazesEquals));
//maze should be equal to loadedMaze
    }
}
