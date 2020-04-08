package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm {
    public DepthFirstSearch() {
        super();
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return super.getNumberOfNodesEvaluated();
    }

    @Override
    public String getName() {
        return "Depth First Search";
    }
    
    @Override
    public Solution solve(ISearchable maze) {
        if(maze==null){
            return null;
        }
        //visited = new HashMap<>();
        evaluatedNodes = 0;
        HashSet<String> visit = new HashSet<>();
        ArrayList<AState> successors;
        Stack<AState> stack = new Stack<>();
        AState start=maze.getStartState();
        AState goal = maze.getGoalState();
        stack.push(start);
        visit.add(((MazeState)start).getPosition().toString());
        while(!stack.isEmpty()){
            AState n = stack.pop();
            if(((MazeState)n).getPosition().equals(((MazeState)(goal)).getPosition())){
                return new Solution(n);
            }
            else{
                successors = maze.getAllSuccessors(n);
                for (AState suc : successors) {
                    if(!visit.contains(((MazeState)suc).getPosition().toString())) {
                        visit.add(((MazeState)suc).getPosition().toString());
                        suc.setParent(n);
                        stack.push(suc);
                        evaluatedNodes++;
                    }

                }
            }
        }
        return null;
    }
}
