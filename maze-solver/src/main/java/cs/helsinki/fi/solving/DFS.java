package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DFS algorithm only for testing.
 *
 */
public class DFS {

    private Maze maze;

    public DFS(Maze maze) {
        this.maze = maze;

    }

    public void solve() {
        Deque<Square> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        Square start = maze.getStart();
        que.add(start);

        while (!que.isEmpty()) {
            Square cur = que.pop();
            System.out.println(cur);

            int x = cur.getHeight();
            int y = cur.getWidth();
            visited[x][y] = true;
        }
    }
}
