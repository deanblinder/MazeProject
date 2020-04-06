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
        while(!stack.isEmpty()){

            AState n = stack.pop();
            //System.out.println(((MazeState)n).getPosition().toString());
//            if(((MazeState)n).getPosition().toString().equals(((MazeState)maze.getGoalState()).getPosition().toString())){
//                return new Solution(n);
//            }

            if(((MazeState)n).getPosition().toString()==((MazeState)(goal)).getPosition().toString()){
                return new Solution(n);
            }
            else{
                successors = maze.getAllSuccessors(n);
                for (AState suc : successors) {
                    if(!visit.contains(suc.toString())&&suc.getParent().equals(n)) {
                        visit.add(suc.toString());
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
//        if (maze != null) {
//            //ashMap<String,Boolean> visit = new HashMap<>();
//            Stack<AState> stack = new Stack<AState>();
//            AState start = maze.getStartState();
//            //AState end = maze.getGoalState();
//            stack.push(start);
//            visited.put(((MazeState)start).getPosition().toString(),true);
//            AState goalState = solveDfs(maze, stack);
//            Solution solution =new Solution(goalState);
//            return solution;
//        }
//        return null;
//    }


//    public AState solveDfs(ISearchable maze,Stack<AState> stack) {
//
//
//
//
//
//    }
//        ArrayList<AState> successors;
//        while(!stack.isEmpty()) {
//            if (((MazeState) stack.peek()).getPosition().equals(((MazeState) maze.getGoalState()).getPosition())) {
//                return stack.peek();
//            }
//            //stack.pop();
//            successors = maze.getAllSuccessors(stack.peek());
//            for (AState suc : successors) {
//                if (!visited.containsKey(((MazeState) suc).getPosition().toString())) {
//                    visited.put(((MazeState) suc).getPosition().toString(), true);
//                    evaluatedNodes++;
//                    stack.push(suc);
//                }
//            }
//            stack.pop();
//
//
//        }
//        //path.push(current);
//        return null;
//    }
//}

//        if(current.LegalUp(maze) && !HMstate.containsKey(current)){
//            HMstate.put(current,true);
//            path.push(current);
//            path = solveDfs(current,end,HMstate,maze,path);
//        }
//        if(current.LegalRight(maze) &&!HMstate.containsKey(current)){
//            path.push(current);
//            HMstate.put(current,true);
//            solveDfs(current,end,HMstate,maze,path);
//        }
//        if(current.LegalDown(maze) &&!HMstate.containsKey(current)){
//            path.push(current);
//            HMstate.put(current,true);
//            solveDfs(current,end,HMstate,maze,path);
//        }
//        if(current.LegalLeft(maze) &&!HMstate.containsKey(current)){
//            path.push(current);
//            HMstate.put(current,true);
//            solveDfs(current,end,HMstate,maze,path);
//        }

//    @Override
//    public ArrayList<AState> getPath(AState state) {
//        return super.getPath(state);
//    }
//}