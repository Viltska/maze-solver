package cs.helsinki.fi.util;

import cs.helsinki.fi.maze.Maze;
import cs.helsinki.fi.maze.Square;
import cs.helsinki.fi.solving.WallFollower;

/**
 * Used for testing the performance of the programs algorithms and data
 * structures.
 *
 * @author Ville Manninen
 *
 */
public class PerformanceTester {

    private static Timer timer;

    /**
     * Creates a PerformanceTester
     */
    public PerformanceTester() {
        PerformanceTester.timer = new Timer();
    }

    /**
     * Runs all tests.
     */
    public void runAllTests() {
        System.out.println("Running performance Tests..");
        System.out.println("n = walkable squares inside maze");

        System.out.println("\n--- SquareQue Tests ---");
        
        queTest(10000000);

        System.out.println("\n--- Generate Maze Tests ---");

        for (int i = 101; i < 1002; i += 100) {
            generateTest(i);
        }

        System.out.println("\n--- Solve Iterative Tests ---");

        for (int i = 101; i < 1002; i += 100) {
            solveLoopTest(i);
        }
        /*

        System.out.println("\n--- Solve Recursvie Tests ---");

        for (int i = 11; i < 1002; i += 10) {
            solveRecursvieTest(i);
        }

        System.out.println("\n Performance tests finished.");
        
         */

    }

    /**
     * Performance test for Generate class.
     *
     * @param size - size of the maze that the test uses.
     */
    public void generateTest(int size) {
        if (size % 2 == 0) {
            size++;
        }
        Maze maze = new Maze(size, size);

        timer.start();
        for (int i = 0; i < 11; i++) {
            maze.generate();
        }
        timer.end();
        System.out.println("Generated size n = " + (size * size / 2) + " maze 10 times, average time used: " + (timer.getMilliSeconds() / 10) + " ms.");

    }

    /**
     * Performance test for SquareQue class.(Adds and removes int size objects).
     *
     * @param size - how many objects are added and removed
     */
    public void queTest(int size) {
        SquareQue sq = new SquareQue();
        Square s = new Square(1, 1);

        timer.start();
        for (int i = 0; i < size + 1; i++) {
            sq.add(s);
        }
        timer.end();
        System.out.println("Added" + size + " objects to SquareQue in " + timer.getMilliSeconds() + " ms.");

        timer.start();
        for (int i = 0; i < size + 1; i++) {

        }

        timer.end();
        System.out.println("Removed " + size + " objects to SquareQue in " + timer.getMilliSeconds() + " ms.");
    }

    /**
     * Performance test for WallFollower class (Iterative solving algorithm).
     *
     * @param size - size of the maze that is solved
     */
    public void solveLoopTest(int size) {
        Maze maze = new Maze(size, size);
        int total = 0;
        WallFollower wf = new WallFollower(maze);
        for (int i = 0; i < 11; i++) {
            maze.generate();
            timer.start();
            wf.solve();
            timer.end();

            total += timer.getMilliSeconds();
        }
        System.out.println("When n = " + (size * size) / 2 + ", average time used: " + (total / 10) + " ms."
        );
    }

    /**
     * Performance test for WallFollower class (Recursive solving algorithm).
     *
     * @param size - size of the maze that is solved
     */
    public void solveRecursvieTest(int size) {
        Maze maze = new Maze(size, size);
        int total = 0;
        WallFollower wf = new WallFollower(maze);
        for (int i = 0; i < 11; i++) {
            maze.generate();
            timer.start();
            wf.solveRecursive();
            timer.end();

            total += timer.getMilliSeconds();
        }
        System.out.println("When n = " + (size * size) / 2 + ", average time used: " + (total / 10) + " ms."
        );

    }
}
