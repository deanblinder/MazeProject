package algorithms.mazeGenerators;
import java.util.Random;

import java.util.ArrayList;
import java.util.*;
public class MyMazeGenerator extends AMazeGenerator {
    public Maze generate(int row, int col) {

        ArrayList<Position> listOfWalls = new ArrayList<Position>();
        EmptyMazeGenerator emptyMaze = new EmptyMazeGenerator();
        Maze myMaze = emptyMaze.generate(row, col);
        //make all maze 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                myMaze.setCellValue(i, j, 1);
            }
        }

        Position startPos=myMaze.chooseStartPosition();
        myMaze.setCellValue(startPos.getRowIndex(), startPos.getColumnIndex(), 0);// set start pos 0
        myMaze=iterative(startPos.getRowIndex(), startPos.getColumnIndex() ,myMaze);
        return myMaze;
    }


    //random direction
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);
        return randoms.toArray(new Integer[4]);
    }
    public Maze iterative(int r, int c , Maze maze) {
        if(maze==null){
            return null;
        }
        int cnt=0;
        // 4 random directions
        boolean flagFirst=true;
        Stack<Position> s = new Stack<Position>();
        Position tempPos = new Position(r,c);
        //maze.setCellValue(r,c,0);

        //flagFirst=false;

        s.push(tempPos);
//        s.pop();
//        maze.print();
//        System.out.println("----------------");
        r=s.peek().getRowIndex();
        c=s.peek().getColumnIndex();
        while(!s.isEmpty()) {

//            if(flagFirst){
//                s.pop();
//                flagFirst=false;
//            }
            boolean upFlag = false;
            boolean downFlag = false;
            boolean rightFlag = false;
            boolean leftFlag = false;


            Integer[] randDirs = generateRandomDirections();
            // Examine each direction
//            r=s.peek().getRow();
//            c=s.peek().getCol();



            for (int i = 0; i < randDirs.length  ; i++) {

                switch (randDirs[i]) {

                    case 1: // Up
                        //　Whether 2 cells up is out or not
                        if (r - 2 < 0){
                            upFlag = true;
                            continue;
                        }

                        if (maze.getCellValue(r - 2, c) != 0) {
                            maze.setCellValue(r - 2, c, 0);

                            Position tempPos2=new Position(r-1,c);
                            maze.setCellValue(r-1,c,0);
                            s.push(tempPos2);
                            Position tempPos1=new Position(r-2,c);
                            maze.setCellValue(r-2,c,0);
                            s.push(tempPos1);
                            r=s.peek().getRowIndex();
                            c=s.peek().getColumnIndex();
                            upFlag = false;
                            downFlag = false;
                            rightFlag = false;
                            leftFlag = false;
//                            System.out.println("up :"+cnt);
//                            cnt++;
//                            System.out.println(tempPos1.toString());
//                            System.out.println(tempPos2.toString());
//                            maze.print();
//                            System.out.println("----------------");
                            break;
                        }
                        upFlag = true;
                    case 2: // Right
                        // Whether 2 cells to the right is out or not
                        if (c + 2 > maze.getCol() - 1) {
                            rightFlag =true;
                            continue;
                        }
                        if (maze.getCellValue(r, c + 2) != 0) {

                            maze.setCellValue(r, c + 1, 0);
                            Position tempPos2=new Position(r,c+1);

                            s.push(tempPos2);

                            Position tempPos1=new Position(r,c+2);
                            maze.setCellValue(r,c+2,0);
                            s.push(tempPos1);
                            r=s.peek().getRowIndex();
                            c=s.peek().getColumnIndex();
                            upFlag = false;
                            downFlag = false;
                            rightFlag = false;
                            leftFlag = false;
//                            System.out.println("right :"+cnt);
//                            cnt++;
//                            System.out.println(tempPos1.toString());
//                            System.out.println(tempPos2.toString());
//                            maze.print();
//                            System.out.println("----------------");
                            break;
                        }
                        rightFlag =true;


                    case 3: // Down
                        // Whether 2 cells down is out or not
                        if (r + 2 > maze.getRow() - 1) {
                            downFlag = true;
                            continue;
                        }
                        if (maze.getCellValue(r + 2, c) != 0) {


                            Position tempPos2=new Position(r+1,c);
                            maze.setCellValue(r+1,c,0);
                            s.push(tempPos2);

                            Position tempPos1=new Position(r+2,c);
                            maze.setCellValue(r+2,c,0);
                            s.push(tempPos1);
                            r=s.peek().getRowIndex();
                            c=s.peek().getColumnIndex();
                            upFlag = false;
                            downFlag = false;
                            rightFlag = false;
                            leftFlag = false;
//                            System.out.println("down :"+cnt);
//                            cnt++;
//                            System.out.println(tempPos1.toString());
//                            System.out.println(tempPos2.toString());
//                            maze.print();
//                            System.out.println("----------------");
                            break;
                        }
                        downFlag = true;
                        //flag=true;
                    case 4: // Left
                        // Whether 2 cells to the left is out or not
                        if (c - 2 < 0){
                            leftFlag = true;
                            continue;
                        }

                        if (maze.getCellValue(r, c - 2) != 0) {


                            Position tempPos2=new Position(r,c-1);
                            maze.setCellValue(r,c-1,0);
                            s.push(tempPos2);

                            Position tempPos1=new Position(r,c-2);
                            maze.setCellValue(r,c-2,0);
                            s.push(tempPos1);
                            r=s.peek().getRowIndex();
                            c=s.peek().getColumnIndex();
                            upFlag = false;
                            downFlag = false;
                            rightFlag = false;
                            leftFlag = false;
//                            System.out.println("left :"+cnt);
//                            cnt++;
//                            System.out.println(tempPos1.toString());
//                            System.out.println(tempPos2.toString());
//                            maze.print();
//                            System.out.println("----------------");
                            break;
                        }
                        leftFlag = true;
                        //flag=true;
                }
            }
            if(downFlag&&upFlag&&rightFlag&&leftFlag){
                if(!s.isEmpty()){
                    s.pop();
                    if(!s.isEmpty()) {
                        r = s.peek().getRowIndex();
                        c = s.peek().getColumnIndex();
                    }
                }
                if(!s.isEmpty()){
                    s.pop();
                    if(!s.isEmpty()) {
                        r = s.peek().getRowIndex();
                        c = s.peek().getColumnIndex();
                    }
                }
                else{
                    break;
                }
            }
        }
       // maze.print();
        Random rand =new Random();
        Position goal = new Position(rand.nextInt(maze.getRow()), rand.nextInt(maze.getCol()));

        while (goal.equals(maze.getStartPosition()) || maze.getCellValue(goal.getRowIndex(),goal.getColumnIndex())==1){
            goal = new Position(rand.nextInt(maze.getRow()), rand.nextInt(maze.getCol()));
        }
        maze.setGoalPosition(goal.getRowIndex(),goal.getColumnIndex(),0);
        return maze;
    }
}