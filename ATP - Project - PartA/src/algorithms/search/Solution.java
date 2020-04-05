package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> sol;

    public Solution(ArrayList<AState> sol) {
        sol = new ArrayList<>();
        this.sol.addAll(sol);
    }

    public ArrayList<AState> getSolutionPath() {
        return sol;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "sol=" + sol +
                '}';
    }

}
