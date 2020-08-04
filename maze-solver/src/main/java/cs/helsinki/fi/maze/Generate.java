package cs.helsinki.fi.maze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class for generating a maze.
 *
 * @author Ville Manninen
 */
public class Generate {

    private final Maze maze;
    private final int width;
    private final int height;
    private final Random random;

    /**
     * Creates a class used to generate a random maze. Requires a Maze class.
     *
     * @param maze - maze that is used for generation
     */
    public Generate(Maze maze) {
        this.maze = maze;
        this.width = maze.getWidth();
        this.height = maze.getHeight();
        this.random = new Random();

    }

    /**
     * Generates a maze using Depth-first search.
     */
    public void generate() {
        maze.generateEmptyMaze();
        ArrayDeque<Square> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[width][height];

        // Marks borders of the maze as visited
        for (int i = 0; i < width; i++) {
            visited[i][0] = true;
            visited[i][height - 1] = true;
        }
        for (int i = 0; i < height; i++) {
            visited[0][i] = true;
            visited[width - 1][i] = true;
        }

        // Begin from start square.
        Square current = maze.getStart();
        visited[current.getWidth()][current.getHeight()] = true;
        // Add to stack
        q.add(current);
        while (!q.isEmpty()) {

            while (hasUnivisited(current, visited)) {
                Square temp = current;
                Square next = getUnivistedNeighbour(current, visited);
                visited[next.getWidth()][next.getHeight()] = true;
                q.add(next);
                current = next;
                maze.setSquareValue(next.getWidth(), next.getHeight(), 0);
                removeWall(temp, next);
            }
            // if no univisited neighbours check previous square
            current = q.pop();
        }
    }

    /**
     * Method for checking if a square has any unvisited neighbours, only checks
     * adjacent squares.
     *
     * @param square - square that is checked
     * @param visited - Boolean array of visited squares
     * @return unvisited - true if any neighbours are unvisited.
     */
    public boolean hasUnivisited(Square square, boolean[][] visited) {
        boolean unvisited = false;
        int x = square.getWidth();
        int y = square.getHeight();
        if (maze.insideGrid(x, y + 2) && visited[x][y + 2] == false) {
            unvisited = true;
        }
        if (maze.insideGrid(x + 2, y) && visited[x + 2][y] == false) {
            unvisited = true;
        }
        if (maze.insideGrid(x - 2, y) && visited[x - 2][y] == false) {
            unvisited = true;
        }
        if (maze.insideGrid(x, y - 2) && visited[x][y - 2] == false) {
            unvisited = true;
        }

        return unvisited;
    }

    /**
     * Removes the wall square between the current and target square. Only works
     * if the parameter squares are neighbours.
     *
     * @param current - current square
     * @param target - the target square
     */
    public void removeWall(Square current, Square target) {
        int x = current.getWidth();
        int y = current.getHeight();
        int dX = target.getWidth();
        int dY = target.getHeight();
        if (Math.abs(y - dY) == 2 || Math.abs(x - dX) == 2) {
            if (maze.insideGrid(x, y) && maze.insideGrid(dX, dY)) {
                // If target square is vertical neighbour.
                if (x == dX) {
                    if (y < dY) {

                        maze.setSquareValue(x, y + 1, 0);
                    } else {
                        maze.setSquareValue(x, y - 1, 0);
                    }

                }

                // if target square is horizontal neighbour.
                if (y == dY) {
                    if (x < dX) {
                        maze.setSquareValue(x + 1, y, 0);
                    } else {
                        maze.setSquareValue(x - 1, y, 0);
                    }
                }
            }
        }
    }

    /**
     * Method for getting a random neighbour of a square.
     *
     * @param square - Square which neighbours will be checked
     * @param visited - Boolean 2D-array of visited squares inside the maze
     * @return Square - a random unvisited neighbour of the given square
     */
    public Square getUnivistedNeighbour(Square square, boolean[][] visited) {
        int x = square.getWidth();
        int y = square.getHeight();
        ArrayList<Square> neighbours = new ArrayList<>();

        if (maze.insideGrid(x, y + 2) && visited[x][y + 2] == false) {
            neighbours.add(new Square(x, y + 2));
        }
        if (maze.insideGrid(x + 2, y) && visited[x + 2][y] == false) {
            neighbours.add(new Square(x + 2, y));
        }
        if (maze.insideGrid(x - 2, y) && visited[x - 2][y] == false) {
            neighbours.add(new Square(x - 2, y));
        }
        if (maze.insideGrid(x, y - 2) && visited[x][y - 2] == false) {
            neighbours.add(new Square(x, y - 2));
        }
        if (!neighbours.isEmpty()) {
            return neighbours.get(random.nextInt(neighbours.size()));
        }
        return null;
    }
}
