package algorithms.mazeGenerators;

import java.util.Random;

public class Maze {

    Position startPosition = new Position(0,0);
    Position goalPosition= new Position(0,0);
    int row;
    int col;
    int [][] theMaze;
    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        this.theMaze = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                this.theMaze[i][j] = 0;
            }
        }

    }

    public Position getStartPosition() {

        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(int r, int c, int val) {
        this.goalPosition.setRow(r);
        this.goalPosition.setCol(c);
        this.theMaze[r][c]=val;
    }

    public Position chooseStartPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        startPosition.setCol(c);
        startPosition.setRow(r);
        //setCellValue(startPosition.getCol(),startPosition.getRow(),8);

        return startPosition;
    }
    public  Position chooseGoalPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        goalPosition.setCol(c);
        goalPosition.setRow(r);
        return goalPosition;
    }
    public void setCellValue(int row,int col,int value) {
        this.theMaze[row][col] = value;
    }

    public int getCellValue(int row,int col) {
        return theMaze[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public int[][] getTheMaze() {
        return theMaze;
    }

    public void print(){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                Position p = new Position(i, j);
                if (p.equals(getStartPosition())) {
                    System.out.print("S  ");
                }
               else if (p.equals(getGoalPosition())) {
                    System.out.print("E  ");
                } else {
                    System.out.print(getCellValue(i, j) + "  ");
                }
            }
            System.out.println();
        }
    }

}

