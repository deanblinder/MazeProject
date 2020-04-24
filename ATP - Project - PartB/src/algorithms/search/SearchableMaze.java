package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchableMaze implements ISearchable {
    private MazeState startState;
    private MazeState goalState;
    private HashMap<String, Boolean> states;
    Maze myMaze;


    public SearchableMaze(Maze maze) {
        startState = new MazeState(maze.getStartPosition());
        goalState  = new MazeState(maze.getGoalPosition());
        //states = new HashMap<>();
        this.myMaze=maze;

    }

    public Maze getMyMaze() {
        return myMaze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(myMaze.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }


    /**
     *
     * @param current current AState
     * @return all possible successors that are valid and legal
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState current) {
        if(current==null){
            return null;
        }
        ArrayList<AState> successors = new ArrayList<>();
        MazeState currState = (MazeState)current;
        Position p2 = new Position(currState.getPosition().getRowIndex()-1,currState.getPosition().getColumnIndex());
        MazeState up = new MazeState(p2);
        Position p3 = new Position(currState.getPosition().getRowIndex(),currState.getPosition().getColumnIndex()+1);
        MazeState right = new MazeState(p3);
        Position p1 = new Position(currState.getPosition().getRowIndex()+1,currState.getPosition().getColumnIndex());
        MazeState down = new MazeState(p1);
        Position p4 = new Position(currState.getPosition().getRowIndex(),currState.getPosition().getColumnIndex()-1);
        MazeState left = new MazeState(p4);


        Position p21 = new Position(currState.getPosition().getRowIndex()-1,currState.getPosition().getColumnIndex()+1);
        MazeState upRight = new MazeState(p21);

        Position p31 = new Position(currState.getPosition().getRowIndex()+1,currState.getPosition().getColumnIndex()+1);
        MazeState rightDown = new MazeState(p31);

        Position p11 = new Position(currState.getPosition().getRowIndex()+1,currState.getPosition().getColumnIndex()-1);
        MazeState downLeft = new MazeState(p11);

        Position p41 = new Position(currState.getPosition().getRowIndex()-1,currState.getPosition().getColumnIndex()-1);
        MazeState upLeft = new MazeState(p41);

        //up
        if(isValidState(up)){
            up.setParent(current);
            up.setCost(10+up.getParent().getCost());
            successors.add(up);
        }
        //up right
        if((isValidState(upRight) && isValidState(up)||(isValidState(upRight) && isValidState(right)))){
            upRight.setParent(current);
            upRight.setCost(15+upRight.getParent().getCost());
            successors.add(upRight);
        }
        //right
        if((isValidState(right))){
            right.setParent(current);
            right.setCost(10+right.getParent().getCost());
            successors.add(right);
        }
        //right down
        if((isValidState(rightDown)&&isValidState(down))||(isValidState(rightDown)&&isValidState(right))){
            rightDown.setParent(current);
            rightDown.setCost(15+rightDown.getParent().getCost());
            successors.add(rightDown);
        }
        //down
        if((isValidState(down))){
            down.setParent(current);
            down.setCost(10+down.getParent().getCost());
            successors.add(down);
        }
        //down left
        if((isValidState(downLeft) && isValidState(down))||(isValidState(downLeft)&&isValidState(left))) {
            downLeft.setParent(current);
            downLeft.setCost(15+downLeft.getParent().getCost());
            successors.add(downLeft);
        }
        //left
        if(isValidState(left)){
            left.setParent(current);
            left.setCost(10+left.getParent().getCost());
            successors.add(left);
        }
        //left up
        if(((isValidState(upLeft) && isValidState(up))||(isValidState(upLeft)&&isValidState(left)))){
            upLeft.setParent(current);
            upLeft.setCost(15+upLeft.getParent().getCost());
            successors.add(upLeft);
        }
//        if(current.getParent()!=null&&successors.contains(current.getParent()){
//            successors.remove(current);
//        }
        return successors;
    }

    /**
     *
     * @param state
     * @return true/false if the state is valid
     */
    public Boolean isValidState(MazeState state){
        if(state==null){
            return false;
        }
        if((state.getPosition().getColumnIndex()<myMaze.getCol() && state.getPosition().getRowIndex()<myMaze.getRow())){
            if( (myMaze.getCellValue(state.getPosition().getRowIndex(),state.getPosition().getColumnIndex())==0)) {
                return true;
            }
        }
        return false;
    }

}
