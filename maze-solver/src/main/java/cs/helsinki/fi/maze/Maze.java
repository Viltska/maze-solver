package cs.helsinki.fi.maze;

import cs.helsinki.fi.solving.DFS;
import java.util.Random;

/**
 * Class for creating a Maze.
 *
 * @version 1.0-SNAPSHOT
 * @author Ville Manninen
 */
public class Maze {

    private final int width;
    private final int height;
    private final int[][] maze;
    private Square start;
    private Square finish;
    private final Random random;
    private final Generate generate;

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
        finish = new Square(random.nextInt(width - 2) + 1, height - 2);

    }

    /**
     * Generates a maze with start and finish.
     *
     * @see Generate.generate()
     */
    public void generate() {
        generateEmptyMaze();
        generate.generate();

        setSquareValue(start.getWidth(), start.getHeight(), 3);
        setSquareValue(finish.getWidth(), finish.getHeight(), 4);

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
     * Method for calling a solving algorithm.
     */
    public void solve() {
        // Todo chose solving algorithm.
    }

    /**
     * Method to get the value of a square. returns -1 if given coordinates are
     * outside of the maze.
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
     * Method for setting value on a Square. value must be between (0-4).
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
     * Method for checking if given coordinates are inside the maze.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @return Boolean - true if inside grid, else false
     */
    public boolean insideGrid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Utility method for checking if given values contain a path inside the
     * grid.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     * @return Boolean - true if inside the gird and a path Square.
     */
    public boolean canMoveTo(int x, int y) {
        if (insideGrid(x, y)) {
            return maze[x][y] == 0;
        }
        return false;
    }

    /**
     * Method to get start Square. Returns null if start Square has not been
     * initialized.
     *
     * @return Square - start Square
     */
    public Square getStart() {
        return start;
    }

    /**
     * Method to get finish Square. Returns null if finish Square has not been
     * initialized.
     *
     * @return Square - finish Square
     */
    public Square getFinish() {
        return finish;
    }

    /**
     * Method to get width.
     *
     * @return int - width of the array
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get height.
     *
     * @return int - height of the array
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method to get a String representation of the maze.
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
