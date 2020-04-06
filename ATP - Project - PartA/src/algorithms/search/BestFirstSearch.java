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

    @Override
    public Solution solve(ISearchable maze){
        Comparator<AState> cost = Comparator.comparing(AState::getCost);
        Queue<AState> queue = new PriorityQueue<>(cost);
        queue.add(maze.getStartState());
        visited.put(maze.getStartState().toString(),true);
        AState goalState=super.solve(maze,queue);
        Solution solution =new Solution(goalState);
        return solution;
    }
}
