package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void solve5_5() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(5,5);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve10_10() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(5,5);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve11_11() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(11,11);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve10_20() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(10,20);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve10_30() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(10,30);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve10_40() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(10,40);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve10_50() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(10,50);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve20_20() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(20,20);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve30_30() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(30,30);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve40_40() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(40,40);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve50_50() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(50,50);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve57_67() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(57,67);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve50_10() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(50,10);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve60_60() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(60,60);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve70_70() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(70,70);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve75_94() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(75,94);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve80_80() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(80,80);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve90_90() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(90,90);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve100_100() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(100,100);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
    @Test
    void solve111_111() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze= mg.generate(111,111);
        SearchableMaze sm = new SearchableMaze(maze);
        ASearchingAlgorithm searcher = new DepthFirstSearch();
        Solution sol =searcher.solve(sm);
        assertFalse(!sol.getSolutionPath().contains(sm.getGoalState()),"no path!");
    }
}