package algorithms.mazeGenerators;

import java.util.Objects;

public class Position {
    int row;
    int col;
    //int val;
    //int [] position;

    public Position(int row,int col){
        this.row=row;
        this.col=col;
        //this.val=val;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
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
