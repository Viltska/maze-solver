package cs.helsinki.fi.util;

import cs.helsinki.fi.maze.Maze;
import cs.helsinki.fi.maze.Square;
import cs.helsinki.fi.solving.WallFollower;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests the performance of the algorithms and data structures.
 *
 * @author Ville Manninen
 *
 */
public class PerformanceTester {

    private static Timer timer;
    private static List<String> results;

    /**
     * Creates a PerformanceTester
     */
    public PerformanceTester() {
        PerformanceTester.timer = new Timer();
        PerformanceTester.results = new ArrayList();

    }

    public void runAll() {
        System.out.println("--- SquareQue ---");

        queTest();

        System.out.println("\n--- Generate Maze ---");

        generateTest(101);
        generateTest(201);
        generateTest(301);
        generateTest(401);
        generateTest(501);
        generateTest(601);
        generateTest(701);
        generateTest(801);
        generateTest(901);
        generateTest(1001);

        System.out.println("\n--- Solve Maze ---");

        solveLoopTest(101);
        solveLoopTest(201);
        solveLoopTest(301);
        solveLoopTest(401);
        solveLoopTest(501);
        solveLoopTest(601);
        solveLoopTest(701);
        solveLoopTest(801);
        solveLoopTest(901);
        solveLoopTest(1001);

    }

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
        System.out.println("Generated size n = " + (size * size) + " naze 10 times, average time was " + (timer.getMilliSeconds() / 10) + " ms.");

    }

    public void queTest() {
        SquareQue sq = new SquareQue();
        Square s = new Square(1, 1);

        timer.start();
        for (int i = 0; i < 10000001; i++) {
            sq.add(s);
        }
        timer.end();
        System.out.println("Added 10 million objects to SquareQue in " + timer.getMilliSeconds() + " ms.");

        timer.start();
        for (int i = 0; i < 10000001; i++) {

        }

        timer.end();
        System.out.println("Removed 10 million objects to SquareQue in " + timer.getMilliSeconds() + " ms.");
    }

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
        System.out.println("When n = " + (size * size) + ", average time was " + (total / 10) + " ms."
        );
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
