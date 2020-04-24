package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    AState endState;

    /**
     *
     * @param state
     */
    public Solution(AState state) {
        this.endState=state;
    }

    /**
     *
     * @return the path of the solution
     */
    public ArrayList<AState> getSolutionPath() {
        Stack<AState> solutionStack = new Stack<AState>();
        ArrayList<AState> finalSol = new ArrayList<>();
        solutionStack.push(endState);
        while (this.endState.getParent()!=null){
            solutionStack.push(this.endState.getParent());
            this.endState=this.endState.getParent();
        }
        while(!solutionStack.isEmpty()){
            finalSol.add(solutionStack.pop());
        }
        return finalSol;
    }

}
