package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchableMaze implements ISearchable {
    private MazeState startState;
    private MazeState goalState;
    private HashMap<String, MazeState> states;

    public SearchableMaze(Maze maze) {
        startState = new MazeState(0,null, maze.getStartPosition());
        goalState  = new MazeState(0,null,maze.getGoalPosition());
        states = new HashMap<>();

    }

    @Override

    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState current) {
        return null;
    }

    public ArrayList<MazeState> getAllSuccessors(MazeState current) {
        ArrayList<MazeState> successors = new ArrayList<MazeState>();
        //double cost, AState cameFrom,Position position


        //up
        Position p2 = new Position(current.getPosition().getRowIndex()-1,current.getPosition().getColIndex());
        MazeState s2 = new MazeState(10,current,p2);
        successors.add(s2);

        //up right
        Position p21 = new Position(current.getPosition().getRowIndex()-1,current.getPosition().getColIndex()+1);
        MazeState s21 = new MazeState(15,current,p21);
        successors.add(s2);

        //right
        Position p3 = new Position(current.getPosition().getRowIndex(),current.getPosition().getColIndex()+1);
        MazeState s3 = new MazeState(10,current,p3);
        successors.add(s3);

        //right down
        Position p31 = new Position(current.getPosition().getRowIndex()+1,current.getPosition().getColIndex()+1);
        MazeState s31 = new MazeState(15,current,p31);
        successors.add(s31);

        //down
        Position p1 = new Position(current.getPosition().getRowIndex()+1,current.getPosition().getColIndex());
        MazeState s1 = new MazeState(10,current,p1);
        successors.add(s1);

        //down left
        Position p11 = new Position(current.getPosition().getRowIndex()+1,current.getPosition().getColIndex()-1);
        MazeState s11 = new MazeState(15,current,p11);
        successors.add(s11);

        //left
        Position p4 = new Position(current.getPosition().getRowIndex(),current.getPosition().getColIndex()-1);
        MazeState s4 = new MazeState(10,current,p4);
        successors.add(s4);

        //left up
        Position p41 = new Position(current.getPosition().getRowIndex()-1,current.getPosition().getColIndex()-1);
        MazeState s41 = new MazeState(15,current,p41);
        successors.add(s41);

        return successors;
    }
}
