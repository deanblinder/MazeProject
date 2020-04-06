package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState {
    private  Position position;

    public MazeState(Position position) {
        super(0,null);
        this.position=position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(position, mazeState.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
