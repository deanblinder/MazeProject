package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    public Maze generate(int row, int col) {
        final Random random = new Random();
        EmptyMazeGenerator emptyMaze=new EmptyMazeGenerator();
        Maze myMaze=emptyMaze.generate(row,col);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                myMaze.setCellValue(i,j,1);
            }
        }
        Position startPos=myMaze.chooseStartPosition();
        myMaze.setCellValue(startPos.getRowIndex(),startPos.getColIndex(),0);
        Position goalPos=myMaze.chooseGoalPosition();
        myMaze.setCellValue(goalPos.getRowIndex(),goalPos.getColIndex(),0);

        if(startPos.getRowIndex()>goalPos.getRowIndex()) {
            for(int i=startPos.getRowIndex();i>=goalPos.getRowIndex();i--) {
                myMaze.setCellValue(i,startPos.getColIndex(),0);

            }
        }
        else{
            for(int i=startPos.getRowIndex();i<=goalPos.getRowIndex();i++) {
                myMaze.setCellValue(i,startPos.getColIndex(),0);

            }

        }


        if(startPos.getColIndex()>goalPos.getColIndex()){
            for(int i=startPos.getColIndex();i>=goalPos.getColIndex();i--){
                myMaze.setCellValue(goalPos.getRowIndex(),i,0);


            }
        }
        else{
            for(int i=startPos.getColIndex();i<=goalPos.getColIndex();i++) {
                myMaze.setCellValue(goalPos.getRowIndex(),i,0);

            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(myMaze.getCellValue(i,j)!=0){
                    int rand;
                    rand = random.nextInt(100);
                    if(rand%2==0){
                        myMaze.setCellValue(i,j,1);
                    }
                    else{
                        myMaze.setCellValue(i,j,0);
                    }
                }
            }
        }

        return myMaze;
    }
}