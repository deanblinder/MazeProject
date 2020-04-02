package algorithms.mazeGenerators;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
public class MyMazeGenerator extends AMazeGenerator {
    ArrayList<int[]> listOfWalls = new ArrayList<int[]>();
    //ArrayList<int[]> listOfCells = new ArrayList<int[]>();
    public Maze generate(int row, int col) {
        EmptyMazeGenerator emptyMaze = new EmptyMazeGenerator();
        Maze myMaze = emptyMaze.generate(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                myMaze.setCellValue(i, j, 1);
            }
        }
        final Random random = new Random();
        int x = random.nextInt(col);
        int y = random.nextInt(row);
        while(x==0 || x==row || y==0 || y==col) {
            while(x%2==0){
                x= random.nextInt(col);
            }
            while(y%2==0){
                y=random.nextInt(row);
            }
        }

        myMaze.setCellValue(x, y, 0);
        itertiv(x, y ,myMaze);
        return myMaze;
    }


    public boolean isCellWall(Maze m, int row, int col,int addRow,int addCol) {
        if (m.getCellValue(row+addRow, col+addCol) == 1) {
            return true;
        }
        return false;
    }

    public boolean isRightCellWall(Maze m, int row, int col) {
        if (m.getCellValue(row, col+1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isLeftCellWall(Maze m, int row, int col) {
        if (m.getCellValue(row, col-1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isUpCellWall(Maze m, int row, int col) {
        if (m.getCellValue(row-1, col) == 1) {
            return true;
        }
        return false;
    }
    public boolean isDownCellWall(Maze m, int row, int col) {
        if (m.getCellValue(row+1, col) == 1) {
            return true;
        }
        return false;
    }

    public void addToListOfWalls(Maze m, int row, int col) {
        if(row==0) {
            if (col == 0) {
                if (isRightCellWall(m, row, col)) {
                    int[] tempWall = {row, col + 1};
                    listOfWalls.add(tempWall);
                }
                if (isDownCellWall(m, row, col)) {
                    int[] tempWall = {row + 1, col};
                    listOfWalls.add(tempWall);
                }
            }
            if (col == m.getCol()) {
                if (isLeftCellWall(m, row, col)) {
                    int[] tempWall = {row, col - 1};
                    listOfWalls.add(tempWall);
                }
                if (isDownCellWall(m, row, col)) {
                    int[] tempWall = {row + 1, col};
                    listOfWalls.add(tempWall);
                }
            } else {
                if (isRightCellWall(m, row, col)) {
                    int[] tempWall = {row, col + 1};
                    listOfWalls.add(tempWall);
                }
                if (isDownCellWall(m, row, col)) {
                    int[] tempWall = {row + 1, col};
                    listOfWalls.add(tempWall);
                }
                if (isLeftCellWall(m, row, col)) {
                    int[] tempWall = {row, col - 1};
                    listOfWalls.add(tempWall);
                }
            }
        }
        if(row==m.getRow()){
            if(col==0) {
                if (isRightCellWall(m, row, col)) {
                    int[] tempWall = {row, col + 1};
                    listOfWalls.add(tempWall);
                }
                if (isUpCellWall(m, row, col)) {
                    int[] tempWall = {row - 1, col};
                    listOfWalls.add(tempWall);
                }
            }
            if(col==m.getCol()) {
                if (isLeftCellWall(m, row, col)) {
                    int[] tempWall = {row, col - 1};
                    listOfWalls.add(tempWall);
                }
                if (isUpCellWall(m, row, col)) {
                    int[] tempWall = {row - 1, col};
                    listOfWalls.add(tempWall);
                }
                else{
                    if (isLeftCellWall(m, row, col)) {
                        int[] tempWall = {row, col - 1};
                        listOfWalls.add(tempWall);
                    }
                    if (isUpCellWall(m, row, col)) {
                        int[] tempWall = {row - 1, col};
                        listOfWalls.add(tempWall);
                    }
                    if(isRightCellWall(m,row,col)){
                        int [] tempWall={row,col+1};
                        listOfWalls.add(tempWall);
                    }
                }
            }
        }
        if(col==0){
            if (isUpCellWall(m, row, col)) {
                int[] tempWall = {row - 1, col};
                listOfWalls.add(tempWall);
            }
            if(isRightCellWall(m,row,col)){
                int [] tempWall={row,col+1};
                listOfWalls.add(tempWall);
            }
            if (isDownCellWall(m, row, col)) {
                int[] tempWall = {row + 1, col};
                listOfWalls.add(tempWall);
            }
        }
        if(col==m.getCol()){
            if (isUpCellWall(m, row, col)) {
                int[] tempWall = {row - 1, col};
                listOfWalls.add(tempWall);
            }
            if (isDownCellWall(m, row, col)) {
                int[] tempWall = {row + 1, col};
                listOfWalls.add(tempWall);
            }
            if (isLeftCellWall(m, row, col)) {
                int[] tempWall = {row, col - 1};
                listOfWalls.add(tempWall);
            }
        }
        else{
            if (isUpCellWall(m, row, col)) {
                int[] tempWall = {row - 1, col};
                listOfWalls.add(tempWall);
            }
            if (isDownCellWall(m, row, col)) {
                int[] tempWall = {row + 1, col};
                listOfWalls.add(tempWall);
            }
            if (isLeftCellWall(m, row, col)) {
                int[] tempWall = {row, col - 1};
                listOfWalls.add(tempWall);
            }
            if(isRightCellWall(m,row,col)){
                int [] tempWall={row,col+1};
                listOfWalls.add(tempWall);
            }
        }
    }
    public void iterate(int x,int y){

    }
    //random direction
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);
        return randoms.toArray(new Integer[4]);
    }
    public void itertiv(int r, int c ,Maze maze) {
        // 4 random directions
        Stack<Integer[]> s = new Stack<Integer[]>();
        Integer[] tempPoint={r,c};
        s.push(tempPoint);

        while(!s.isEmpty()) {
            boolean flag = false;
            Integer[] randDirs = generateRandomDirections();
            // Examine each direction

            for (int i = 0; i < randDirs.length; i++) {

                switch (randDirs[i]) {

                    case 1: // Up
                        //　Whether 2 cells up is out or not
                        if (r - 2 <= 0)
                            continue;
                        if (maze.getCellValue(r - 2, c) != 0) {
                            maze.setCellValue(r - 2, c, 0);
                            Integer[] tempPoint1={r-2,c};
                            s.push(tempPoint1);
                            maze.setCellValue(r - 1, c, 0);
                            Integer[] tempPoint2={r-1,c};
                            s.push(tempPoint2);
                            flag=true;

                        }
                        break;
                    case 2: // Right
                        // Whether 2 cells to the right is out or not
                        if (c + 2 >= maze.getCol() - 1)
                            continue;
                        if (maze.getCellValue(r, c + 2) != 0) {
                            maze.setCellValue(r, c + 2, 0);
                            Integer[] tempPoint1={r,c+2};
                            s.push(tempPoint1);
                            maze.setCellValue(r, c + 1, 0);
                            Integer[] tempPoint2={r,c+1};
                            s.push(tempPoint1);
                            flag=true;
                        }
                        break;
                    case 3: // Down
                        // Whether 2 cells down is out or not
                        if (r + 2 >= maze.getRow() - 1)
                            continue;
                        if (maze.getCellValue(r + 2, c) != 0) {
                            maze.setCellValue(r + 2, c, 0);
                            Integer[] tempPoint1={r+2,c};
                            s.push(tempPoint1);
                            maze.setCellValue(r + 1, c, 0);
                            Integer[] tempPoint2={r+1,c};
                            s.push(tempPoint1);
                            flag=true;
                        }
                        break;
                    case 4: // Left
                        // Whether 2 cells to the left is out or not
                        if (c - 2 <= 0)
                            continue;
                        if (maze.getCellValue(r, c - 2) != 0) {
                            maze.setCellValue(r, c - 2, 0);
                            Integer[] tempPoint1={r,c-2};
                            s.push(tempPoint1);
                            maze.setCellValue(r, c - 1, 0);
                            Integer[] tempPoint2={r,c-2};
                            s.push(tempPoint1);
                            flag=true;
                        }
                        break;
                }
            }
            if(flag=false){
                s.pop();
            }

        }

    }
}