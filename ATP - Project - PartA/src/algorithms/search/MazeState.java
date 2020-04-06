package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState {
    private  Position position;

    public MazeState(Position position) {
        super(0,null);
        this.position = new Position(position.getRowIndex(),position.getColIndex());
        //this.position=position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if(position==null){
            return;
        }
        this.position = position;
    }

    @Override
    public String toString() {
        return "MazeState{" +
                "position=" + position +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        MazeState mazeState = (MazeState) o;
        return Objects.equals(position.toString(), mazeState.position.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
