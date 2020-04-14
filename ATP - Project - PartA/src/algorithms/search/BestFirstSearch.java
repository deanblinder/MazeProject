package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {

    public BestFirstSearch() {
        super();
    }
    @Override
    public String getName() {
        return "Best First Search";
    }

    /**
     *
     * @param maze
     * @return solved maze
     */
    @Override
    public Solution solve(ISearchable maze){
        if(maze==null){
            return null;
        }
        visited = new HashMap<>();
        evaluatedNodes = 0;
        Comparator<AState> cost = Comparator.comparing(AState::getCost);
        Queue<AState> queue = new PriorityQueue<>(cost);
        queue.add(maze.getStartState());
        visited.put(maze.getStartState().toString(),true);
        AState goalState=super.solve(maze,queue);
        Solution solution =new Solution(goalState);
        return solution;
    }
}
