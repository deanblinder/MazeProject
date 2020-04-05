package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {


    public BestFirstSearch() {
        super();
    }
    @Override
    public Solution solve(ISearchable maze){

        Comparator<AState> path=Comparator.comparing(AState::getCost);
        PriorityQueue<AState> queue = new PriorityQueue<>(path);
        queue.add(maze.getStartState());


        AState goalState=super.solve(maze,queue);
        Solution solution =new Solution(super.getPath(goalState));
        return solution;
    }
}
