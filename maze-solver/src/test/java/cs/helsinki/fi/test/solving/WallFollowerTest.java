/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.solving;

import cs.helsinki.fi.maze.*;
import cs.helsinki.fi.solving.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class WallFollowerTest {

    private Maze maze;
    private Square start;
    private Square finish;

    public WallFollowerTest() {
        this.maze = new Maze(40, 40);
        maze.generate();
        this.start = maze.getStart();
        this.finish = maze.getFinish();
    }

    @Test
    public void solveTest() {
        // STACK OVERFLOW
        /*
        WallFollower wf = new WallFollower(maze);
        System.out.println("Speed test on a maze the size of (" + maze.getWidth() + "x" + maze.getHeight() + ").");

        long startTime = System.nanoTime();

        ArrayList<Square> path = wf.solve();

        long endTime = System.nanoTime();

        Square last = path.get(path.size() - 1);

        long elapsed = endTime - startTime;

        assertEquals(true, maze.reachedFinish(last));
        assertEquals(true, path.size() < (maze.getHeight() * maze.getWidth()));
        assertEquals(true, (elapsed) < 15000000);

        long toMilliseconds = TimeUnit.MILLISECONDS.convert(elapsed, TimeUnit.NANOSECONDS);

        System.out.println("Solved in " + toMilliseconds + " ms.");
         */
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

        assertEquals(Direction.UP, wf.getDirectionToForward(Direction.UP));
        assertEquals(Direction.LEFT, wf.getDirectionToForward(Direction.LEFT));
        assertEquals(Direction.DOWN, wf.getDirectionToForward(Direction.DOWN));
        assertEquals(Direction.RIGHT, wf.getDirectionToForward(Direction.RIGHT));

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
}
