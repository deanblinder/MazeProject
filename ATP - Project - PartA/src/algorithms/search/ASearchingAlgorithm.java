package algorithms.search;
import java.util.ArrayList;
import java.util.HashMap;


public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    HashMap<String, Boolean> visited;
    int evaluatedNodes;

    public ASearchingAlgorithm() {
        visited = new HashMap<String, Boolean>();
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


}