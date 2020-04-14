package algorithms.mazeGenerators;

import java.util.Random;

public class Maze {

    Position startPosition = new Position(0,0);
    Position goalPosition= new Position(0,0);
    int row;
    int col;
    int [][] theMaze;

    /**
     * constructor of an empty maze
     * @param row number of rows
     * @param col number of columns
     */
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

    /**
     *
     * @return start Position
     */
    public Position getStartPosition() {

        return startPosition;
    }

    /**
     *
     * @return goal Position
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     *
     * @param r row number
     * @param c col number
     * @param val value of goal position
     */
    public void setGoalPosition(int r, int c, int val) {
        this.goalPosition.setRow(r);
        this.goalPosition.setCol(c);
        this.theMaze[r][c]=val;
    }

    /**
     *
     * @return random start position
     */
    public Position chooseStartPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        startPosition.setCol(c);
        startPosition.setRow(r);
        //setCellValue(startPosition.getCol(),startPosition.getRow(),8);

        return startPosition;
    }

    /**
     *
     * @return random goal position
     */
    public  Position chooseGoalPosition(){
        final Random random = new Random();
        int c = random.nextInt(col-1)+1;
        int r = random.nextInt(row-1)+1;
        goalPosition.setCol(c);
        goalPosition.setRow(r);
        return goalPosition;
    }

    /**
     *
     * @param row row number
     * @param col col number
     * @param value value of maze[row][col]
     */
    public void setCellValue(int row,int col,int value) {
        this.theMaze[row][col]=value;

    }

    /**
     *
     * @param row row number
     * @param col col number
     * @return the value of maze[row][col]
     */
    public int getCellValue(int row,int col) {
        if(row<this.row && col<this.col && col>=0 && row>=0){
            return theMaze[row][col];
        }
        return -1;
    }

    /**
     *
     * @return the number of rows
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the number of columns
     */
    public int getCol() {
        return col;
    }

    /**
     *
     * @return the maze
     */
    public int[][] getTheMaze() {
        return theMaze;
    }

    /**
     * print the maze;
     */
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

