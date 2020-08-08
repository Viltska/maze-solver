package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;

/**
 * DFS algorithm only for testing.
 *
 * @author Ville Manninen
 */
public class DFS {

    private Maze maze;

    public DFS(Maze maze) {
        this.maze = maze;

    }

    public void solve() {
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        util(maze.getStart(), visited);

    }

    public void util(Square current, boolean visited[][]) {
        if (maze.reachedFinish(current)) {
            return;
        }
        System.out.println("->" + current.toString());
        int x = current.getHeight();
        int y = current.getWidth();

        visited[x][y] = true;

        while (true) {

            if (maze.canMoveTo(x - 1, y) && visited[x - 1][y] == false) {
                Square next = new Square(x - 1, y);
                util(next, visited);

            }
            if (maze.canMoveTo(x, y - 1) && !visited[x][y - 1] == false) {
                Square next = new Square(x, y - 1);
                util(next, visited);

            }
            if (maze.canMoveTo(x + 1, y) && !visited[x + 1][y] == false) {
                Square next = new Square(x + 1, y);
                util(next, visited);

            }
            if (maze.canMoveTo(x, y + 1) && !visited[x][y + 1] == false) {
                Square next = new Square(x, y + 1);
                util(next, visited);

            }
            break;
        }
    }
}
