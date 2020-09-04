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
     * Creates a PerformanceTester.
     */
    public PerformanceTester() {
        PerformanceTester.timer = new Timer();
    }

    /**
     * Runs all tests.
     */
    public void runAllTests() {
        try {
            System.out.println("Running all performance tests..\n");

            System.out.println("\n--- SquareQue Tests ---");

            queTest(10000000);

            System.out.println("\n--- Generate Maze Tests ---");

            for (int i = 101; i < 1002; i += 100) {
                generateTest(i);
            }

            System.out.println("\n--- Solve Iterative Tests ---");

            for (int i = 101; i < 1002; i += 100) {
                solveIterativeTest(i);
            }
            System.out.println("\n--- Iterative vs. Recursive Tests ---");

            for (int i = 51; i < 151; i += 50) {
                compareIterativeToRecursiveTest(i);
            }

            System.out.println("\nAll performance tests finished.");

        } catch (Exception e) {
            System.out.println("Error running tests, error: " + e);
        }
    }

    /**
     * Performance test for Generate class.
     *
     * @param size - size of the maze that the test uses.
     */
    public static void generateTest(int size) {
        if (size % 2 == 0) {
            size++;
        }
        Maze maze = new Maze(size, size);

        timer.start();
        for (int i = 0; i < 11; i++) {
            maze.generate();
        }
        timer.end();
        System.out.println("Generated size " + size + " x " + size + " maze 10 times, average time used: " + timer.getMilliSeconds() + " ms.");

    }

    /**
     * Performance test for SquareQue class.(Adds and removes int size objects).
     *
     * @param size - how many objects are added and removed
     */
    public static void queTest(int size) {
        SquareQueue sq = new SquareQueue();
        Square s = new Square(1, 1);

        timer.start();
        for (int i = 0; i < size + 1; i++) {
            sq.add(s);

        }
        timer.end();

        System.out.println("Added " + size + " objects to SquareQue in " + timer.getMilliSeconds() + " ms.");

        timer.start();
        for (int i = 0; i < size + 1; i++) {
            sq.pop();

        }
        timer.end();
        System.out.println("Removed " + size + " objects to SquareQue in " + timer.getMilliSeconds() + " ms.");
    }

    /**
     * Performance test for WallFollower class (Iterative solving algorithm).
     *
     * @param size - size of the maze that is solved
     */
    public static void solveIterativeTest(int size) {
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
        System.out.println("Solved size " + (size * size) / 2 + ", average time used: " + (total / 10) + " ms."
        );
    }

    /**
     * Performance test for WallFollower class (Recursive solving algorithm).
     *
     * @param size - size of the maze that is solved
     */
    public static void solveRecursvieTest(int size) {
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
        System.out.println("Solved size " + (size * size) / 2 + ", average time used: " + (total / 10) + " ms.");

    }

    /**
     * Compares the performance of the iterative and recursive WallFollower
     * algorithms.
     *
     * @param size - size of the maze that is being compared
     */
    public static void compareIterativeToRecursiveTest(int size) {
        Maze maze = new Maze(size, size);
        long totalIterative = 0;
        long totalRecursive = 0;
        WallFollower wf = new WallFollower(maze);
        for (int i = 0; i < 11; i++) {
            maze.generate();

            timer.start();
            wf.solveRecursive();
            timer.end();
            totalRecursive += timer.getNanoSeconds();

            timer.start();
            wf.solve();
            timer.end();
            totalIterative += timer.getNanoSeconds();

        }
        System.out.println("Iterative solved size " + (size * size) / 2 + ", average time used: " + (totalIterative / 10) + " ns.");
        System.out.println("Recursive solved size " + (size * size) / 2 + ", average time used: " + (totalRecursive / 10) + " ns.");
        System.out.println("---");
    }
}
