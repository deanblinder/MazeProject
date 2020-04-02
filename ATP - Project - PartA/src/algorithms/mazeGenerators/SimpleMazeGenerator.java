package algorithms.mazeGenerators;

import algorithms.mazeGenerators.Maze;
import java.lang.Math;
public class SimpleMazeGenerator {
    public Maze genarate(int row, int col) {
        int rand;
        EmptyMazeGenerator emptyMaze=new EmptyMazeGenerator();
        Maze m=emptyMaze.generate(row,col);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                rand=(int)Math.random()*100;
                if(rand%2==0){
                    m.setCellValue(i,j,0);
                }
                else{
                    m.setCellValue(i,j,1);
                }
            }
        }
        return m;
    }
}