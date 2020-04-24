package algorithms.mazeGenerators;

public class Position {
    int row;
    int col;

    /**
     * constructor of Position in maze
     * @param row
     * @param col
     */
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return col;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                col == position.col;
    }

}
