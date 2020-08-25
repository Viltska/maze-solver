package cs.helsinki.fi.maze;

import cs.helsinki.fi.solving.WallFollower;
import cs.helsinki.fi.util.RandomGenerator;
import cs.helsinki.fi.util.SquareList;
import cs.helsinki.fi.util.Timer;
import java.util.Random;

/**
 * Class for creating a Maze.
 *
 * @author Ville Manninen
 */
public class Maze {

    private final int width;
    private final int height;
    private final int[][] maze;
    private Square start;
    private Square finish;
    private final Generate generate;
    private final Timer timer;

    // TODO Replace
    private final Random random;
    private final RandomGenerator myRandom;

    /**
     * Creates an empty Maze.
     *
     * @param width - width of the Maze
     * @param height - height of the Maze
     */
    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new int[this.width][this.height];
        this.random = new Random();
        this.myRandom = new RandomGenerator();
        this.timer = new Timer();

        // Maze generation class
        this.generate = new Generate(this);
    }

    /**
     * Method for generating an empty maze with start and finish Squares.
     */
    public void generateEmptyMaze() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        start = new Square(1, 1);

        int randomWitdh = myRandom.generate((width - 2) + 1);
        finish = new Square(randomWitdh, height - 2);

    }

    /**
     * Generates a maze with start and finish.
     *
     * @see Generate.generate()
     */
    public void generate() {
        timer.setStartCurrent();

        generateEmptyMaze();
        generate.generate();

        setSquareValue(start.getWidth(), start.getHeight(), 3);
        setSquareValue(finish.getWidth(), finish.getHeight(), 4);

        timer.setEndCurrent();
        System.out.println("Generated in " + timer.toString());

    }

    /**
     * Method for checking is given square is a neighbour of the finish Square.
     *
     * @param square - current Square
     * @return Boolean - returns true if next to finish Square.
     */
    public boolean reachedFinish(Square square) {
        boolean reached = false;
        int x = square.getWidth();
        int y = square.getHeight();
        if (insideGrid(x, y)) {
            if (insideGrid(x + 1, y)) {
                reached = maze[x + 1][y] == 4;
            }
            if (insideGrid(x, y + 1) && !reached) {
                reached = maze[x][y + 1] == 4;
            }
            if (insideGrid(x - 1, y) && !reached) {
                reached = maze[x - 1][y] == 4;
            }
            if (insideGrid(x, y - 1) && !reached) {
                reached = maze[x][y - 1] == 4;
            }

        }
        return reached;
    }

    /**
     * Solves the maze.
     */
    public void solve() {
        System.out.println("Loop called");
        WallFollower wf = new WallFollower(this);

        timer.setStartCurrent();

        SquareList sl = wf.solve();

        timer.setEndCurrent();

        System.out.println("Solved in " + timer.toString());

        for (int i = 0; i < sl.size(); i++) {
            Square current = sl.getIndex(i);
            maze[current.getWidth()][current.getHeight()] = 2;
        }
        setSquareValue(start.getWidth(), start.getHeight(), 3);
    }

    /**
     * Solves the maze with chosen algorithm.
     *
     * @param setting - String name of the algorithm
     */
    public void solve(String setting) {

        WallFollower wf = new WallFollower(this);
        SquareList sl;

        timer.setStartCurrent();

        if (setting.equals("Recursive")) {
            System.out.println("Recursive called");
            sl = wf.solveRecursive();
        } else {
            System.out.println("Loop called in recursive");
            sl = wf.solve();
        }

        timer.setEndCurrent();
        System.out.println("Solved in " + timer.toString());

        for (int i = 0; i < sl.size(); i++) {
            Square current = sl.getIndex(i);
            maze[current.getWidth()][current.getHeight()] = 2;
        }
        setSquareValue(start.getWidth(), start.getHeight(), 3);
    }

    /**
     * Gets the value of a square. returns -1 if given coordinates are outside
     * of the maze.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @return int - value of the coordinates
     */
    public int getSquareValue(int x, int y) {
        if (insideGrid(x, y)) {
            return maze[x][y];
        }
        return -1;
    }

    /**
     * Sets a value on the 2D-array, accepts values between 0 - 4.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @param value - set value
     */
    public void setSquareValue(int x, int y, int value) {
        if (insideGrid(x, y)) {
            if (value == 0 || value == 1 || value == 2 || value == 3 || value == 4) {
                maze[x][y] = value;
            }
        }
    }

    /**
     * Checks if given coordinates are inside the maze.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @return Boolean - true if inside grid, else false
     */
    public boolean insideGrid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Checks if coordinates contain an allowed path.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @return Boolean - true if inside the gird and a path Square.
     */
    public boolean canMoveTo(int x, int y) {
        if (insideGrid(x, y)) {
            int val = maze[x][y];
            if (val == 0 || val == 3 || val == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns starting Square. Returns null if start Square has not been
     * initialized.
     *
     * @return Square - start Square
     */
    public Square getStart() {
        return start;
    }

    /**
     * Returns finish Square. Returns null if finish Square has not been
     * initialized.
     *
     * @return Square - finish Square
     */
    public Square getFinish() {
        return finish;
    }

    /**
     * Returns width of the maze.
     *
     * @return int - width of the maze[][] array.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns height of the maze.
     *
     * @return int - height of the maze[][] array.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns String representation of the maze[][] array.
     *
     * @return String - Maze as a String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(getSquareValue(j, i));
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
