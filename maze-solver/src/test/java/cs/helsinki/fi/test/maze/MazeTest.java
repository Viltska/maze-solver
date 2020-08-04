package cs.helsinki.fi.test.maze;

import java.util.ArrayList;
import cs.helsinki.fi.maze.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class MazeTest {

    public MazeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Maze maze = new Maze(20, 10);
        assertEquals(10, maze.getHeight());
        assertEquals(20, maze.getWidth());

    }

    @Test
    public void getSquareValueTest() {
        Maze maze = new Maze(3, 3);
        assertEquals(0, maze.getSquareValue(0, 0));
        assertEquals(-1, maze.getSquareValue(3, 3));
    }

    @Test
    public void reachedFinishTest() {
        Maze maze = new Maze(10, 10);
        maze.setSquareValue(5, 5, 4);

        assertEquals(true, maze.reachedFinish(new Square(5 - 1, 5)));
        assertEquals(true, maze.reachedFinish(new Square(5, 5 - 1)));
        assertEquals(true, maze.reachedFinish(new Square(5 + 1, 5)));
        assertEquals(true, maze.reachedFinish(new Square(5, 5 + 1)));
        assertEquals(false, maze.reachedFinish(new Square(5 + 1, 5 + 1)));
        assertEquals(false, maze.reachedFinish(new Square(5 - 1, 5 - 1)));

        maze.setSquareValue(0, 0, 4);
        assertEquals(true, maze.reachedFinish(new Square(0, 1)));
        assertEquals(true, maze.reachedFinish(new Square(1, 0)));
        assertEquals(false, maze.reachedFinish(new Square(1, 1)));
        assertEquals(false, maze.reachedFinish(new Square(0, -1)));
        assertEquals(false, maze.reachedFinish(new Square(-1, 0)));

    }

    @Test
    public void setSquareValueTest() {
        Maze maze = new Maze(10, 10);
        maze.setSquareValue(0, 0, 1);
        assertEquals(1, maze.getSquareValue(0, 0));
        maze.setSquareValue(0, 0, 0);
        assertEquals(0, maze.getSquareValue(0, 0));
        maze.setSquareValue(0, 0, 2);
        assertEquals(2, maze.getSquareValue(0, 0));
        maze.setSquareValue(0, 0, 3);
        assertEquals(3, maze.getSquareValue(0, 0));
        maze.setSquareValue(0, 0, 4);
        assertEquals(4, maze.getSquareValue(0, 0));
        maze.setSquareValue(0, 0, 5);
        assertEquals(4, maze.getSquareValue(0, 0));

    }

    @Test
    public void GenerateEmptyMazeTest() {
        Maze maze = new Maze(5, 5);
        maze.generateEmptyMaze();

        ArrayList<Integer> mazeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int val = maze.getSquareValue(i, j);
                mazeList.add(val);
            }
        }
        boolean containsWall = mazeList.stream().anyMatch(s -> (s == 1));
        boolean containsEmpty = mazeList.stream().anyMatch(s -> (s == 0));

        assertEquals(true, containsWall);
        assertEquals(false, containsEmpty);

    }

    @Test
    public void insideGridTest() {
        Maze maze = new Maze(11, 11);

        assertEquals(true, maze.insideGrid(0, 0));
        assertEquals(true, maze.insideGrid(10, 0));
        assertEquals(true, maze.insideGrid(0, 10));
        assertEquals(true, maze.insideGrid(10, 10));

        assertEquals(false, maze.insideGrid(-1, 0));
        assertEquals(false, maze.insideGrid(0, -1));
        assertEquals(false, maze.insideGrid(11, 0));
        assertEquals(false, maze.insideGrid(0, 11));
    }

    @Test
    public void generateTest() {

    }

    @Test
    public void testStart() {
        Maze maze = new Maze(10, 10);
        Square start = maze.getStart();
    }

    @Test
    public void toStringTest() {
        Maze maze = new Maze(11, 11);
        maze.generateEmptyMaze();

        String empty = maze.toString();
        assertEquals(false, empty.isEmpty());
        assertEquals(false, empty.isBlank());
    }
}
