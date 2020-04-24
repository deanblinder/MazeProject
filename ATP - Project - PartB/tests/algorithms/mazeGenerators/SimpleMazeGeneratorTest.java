package algorithms.mazeGenerators;

import algorithms.search.ISearchable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMazeGeneratorTest {

    @Test
    void generate10_10() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(10,10);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate5_5() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(5,5);
        assertTrue(maze!=null,"problem: maze is null");

    }
    @Test
    void generate11_11() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(11,11);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate10_20() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(10,20);
        assertTrue(maze!=null,"problem: maze is null");

    }
    @Test
    void generate10_30() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(10,30);
        assertTrue(maze!=null,"problem: maze is null");

    }
    @Test
    void generate10_40() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(10,40);
        assertTrue(maze!=null,"problem: maze is null");

    }
    @Test
    void generate10_50() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(10,50);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate20_20() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(20,20);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate30_30() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(20,20);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate40_40() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(40,40);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate50_50() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(50,50);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate57_67() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(57,67);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate50_10() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(50,10);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate60_60() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(50,60);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate70_70() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(70,70);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate75_94() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(75,94);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate80_80() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(80,80);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate90_90() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(90,90);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate100_100() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(100,100);
        assertTrue(maze!=null,"problem: maze is null");
    }
    @Test
    void generate111_111() {
        AMazeGenerator m = new SimpleMazeGenerator();
        Maze maze = m.generate(111,111);
        assertTrue(maze!=null,"problem: maze is null");
    }
}