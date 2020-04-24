package algorithms.search;

public interface ISearchingAlgorithm {
    Solution solve(ISearchable maze);
    String getName();
    int getNumberOfNodesEvaluated();

}
