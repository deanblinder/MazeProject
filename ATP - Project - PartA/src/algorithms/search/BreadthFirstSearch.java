package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.*;
public class BreadthFirstSearch extends ASearchingAlgorithm {

    public BreadthFirstSearch() {
        super();
        //visited = new HashMap<>();
    }

    @Override
    public String getName() {
        return "Breadth First Search";
    }


    @Override
    public Solution solve(ISearchable maze){
        if(maze==null){
            return null;
        }
        visited = new HashMap<>();
        evaluatedNodes = 0;
        Queue<AState> queue = new LinkedList<>();
        queue.add(maze.getStartState());
        visited.put(maze.getStartState().toString(),true);
        AState goalState = solve(maze, queue);
        Solution solution =new Solution(goalState);
        return solution;
    }
    public AState solve(ISearchable maze,Queue<AState> queue) {
        if(maze==null || queue == null){
            return null;
        }

        ArrayList<AState> successors;
        AState curr;
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(((MazeState)curr).getPosition().equals(((MazeState)(maze.getGoalState())).getPosition())){
                return curr;
            }
            else{
                successors = maze.getAllSuccessors(curr);
                for(AState suc:successors){
                    if(!visited.containsKey(suc.toString())){
                        visited.put(suc.toString(),true);
                        suc.setParent(curr);
                        queue.add(suc);
                        evaluatedNodes++;
                    }
                }
            }
        }
        return null;
    }
}
