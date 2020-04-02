package algorithms.mazeGenerators;

public class Maze {
    int row;
    int col;
    int [][] theMaze;
    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        int[][] m = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                m[row][col] = 0;
            }
        }
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
}

