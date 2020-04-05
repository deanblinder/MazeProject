package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public BreadthFirstSearch() {
        super();
        states = new HashMap<>();
    }


//    @Override
//    public int getNumberOfNodesEvaluated() {
//        return super.getNumberOfNodesEvaluated();
//    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }


    @Override
    public Solution solve(ISearchable maze){
        Queue<AState> queue = new LinkedList<>();
        queue.add(maze.getStartState());
        AState goalState=solve(maze,queue);
        Solution solution =new Solution(super.getPath(goalState));
        return solution;
    }



    public AState solve(ISearchable maze,Queue<AState> queue) {
        AState curr_state;
        while(!queue.isEmpty()){
            curr_state =queue.remove();
            if(curr_state.equals(maze.getGoalState()) ){
                return curr_state;
            }
            ArrayList<AState> successors=maze.getAllSuccessors(curr_state);
            //successors.sort(Comparator.comparing(AState::getCost));
          for(int i=0;i<successors.size();i++){
              AState s = successors.get(i);
              if (!states.containsKey(s.toString())) {
                  states.put(s.toString(), s);
                  s.setCost(s.getCameFrom().getCost() + s.getCost());
                  s.setCameFrom(curr_state);
                  queue.add(s);
              }
          }
        }
        return null;
    }
}
