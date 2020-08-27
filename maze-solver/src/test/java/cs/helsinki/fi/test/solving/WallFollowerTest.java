/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.solving;

import cs.helsinki.fi.maze.*;
import cs.helsinki.fi.solving.*;
import cs.helsinki.fi.util.SquareQue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class WallFollowerTest {

    private static Maze maze;

    public WallFollowerTest() {
        WallFollowerTest.maze = new Maze(41, 41);
        maze.generate();
    }

    @Test
    public void getDirectionTest() {
        WallFollower wf = new WallFollower(maze);

        assertEquals(Direction.RIGHT, wf.getDirectionToRight(Direction.UP));
        assertEquals(Direction.UP, wf.getDirectionToRight(Direction.LEFT));
        assertEquals(Direction.LEFT, wf.getDirectionToRight(Direction.DOWN));
        assertEquals(Direction.DOWN, wf.getDirectionToRight(Direction.RIGHT));

        assertEquals(Direction.LEFT, wf.getDirectionToLeft(Direction.UP));
        assertEquals(Direction.DOWN, wf.getDirectionToLeft(Direction.LEFT));
        assertEquals(Direction.RIGHT, wf.getDirectionToLeft(Direction.DOWN));
        assertEquals(Direction.UP, wf.getDirectionToLeft(Direction.RIGHT));

    }

    @Test
    public void rotateTest() {
        WallFollower wf = new WallFollower(maze);

        assertEquals(Direction.LEFT, wf.rotateLeft(Direction.UP));
        assertEquals(Direction.DOWN, wf.rotateLeft(Direction.LEFT));
        assertEquals(Direction.RIGHT, wf.rotateLeft(Direction.DOWN));
        assertEquals(Direction.UP, wf.rotateLeft(Direction.RIGHT));
    }

    @Test
    public void reverseTest() {
        WallFollower wf = new WallFollower(maze);

        assertEquals(Direction.DOWN, wf.reverse(Direction.UP));
        assertEquals(Direction.RIGHT, wf.reverse(Direction.LEFT));
        assertEquals(Direction.UP, wf.reverse(Direction.DOWN));
        assertEquals(Direction.LEFT, wf.reverse(Direction.RIGHT));

    }

    @Test
    public void solveTest() {
        WallFollower wf = new WallFollower(maze);
        SquareQue sl = wf.solve();
        assertEquals(true, maze.reachedFinish(sl.peekLast()));
    }

    @Test
    public void solveRecursiveTest() {
        WallFollower wf = new WallFollower(maze);
        SquareQue sl = wf.solveRecursive();
        assertEquals(true, maze.reachedFinish(sl.peekLast()));
    }

}
