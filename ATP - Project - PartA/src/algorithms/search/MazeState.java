package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState {
    Position position;
    MazeState cameFrom;
    double cost;
    public MazeState(double cost, MazeState cameFrom, Position position) {
        this.cost=cost;
        this.cameFrom=cameFrom;
        this.position=position;
    }

    @Override
    public double getCost() {
        return super.getCost();
    }

    @Override
    public void setCost(double cost) {
        super.setCost(cost);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public MazeState getCameFrom() {
        return this.getCameFrom();
    }

    @Override
    public void setCameFrom(AState cameFrom) {
        super.setCameFrom(cameFrom);
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
