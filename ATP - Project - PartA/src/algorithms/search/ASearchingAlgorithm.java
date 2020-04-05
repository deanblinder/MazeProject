package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    HashMap<String, AState> states;
    int evaluatedNodes;

    public ASearchingAlgorithm() {
        states = new HashMap<String, AState>();
        evaluatedNodes  = 0;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return evaluatedNodes ;
    }

    @Override
    public abstract String getName();

    @Override
    public Solution solve(ISearchable maze) {
        return null;
    }

    public ArrayList<AState> getPath(AState state) {
        ArrayList<AState> result_path = new ArrayList<>();
        while(state.getCameFrom()!=null){
            result_path.add(0,state);
        }
        result_path.add(0,state);
        return result_path;
    }




}
