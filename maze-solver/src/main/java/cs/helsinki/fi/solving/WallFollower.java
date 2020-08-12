package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;
import java.util.ArrayList;

/**
 * Wall Follower algorithm.
 *
 */
public class WallFollower {

    public enum Direction {
        UP,
        LEFT,
        RIGHT,
        DOWN
    }

    private Maze maze;

    /**
     * Creates a instance of WallFollower class.
     *
     * @param maze - Maze that the algorithm will use
     */
    public WallFollower(Maze maze) {
        this.maze = maze;

    }

    /**
     * General method called from parent class for solving the maze.
     */
    public void solve() {
        Square start = maze.getStart();

        System.out.println("can move to UP:" + canMove(start, Direction.UP));
        System.out.println("can move to DOWN:" + canMove(start, Direction.DOWN));
        System.out.println("can move to RIGHT:" + canMove(start, Direction.RIGHT));
        System.out.println("can move to LEFT:" + canMove(start, Direction.LEFT));

        ArrayList<Square> path = new ArrayList<>();

        move(start, Direction.LEFT, path);

        System.out.println("Path:");
        path.forEach(System.out::println);

    }

    /**
     * Used to move in wanted direction, will continue moving recursively before
     * reaching finish.
     *
     * @param postition - Square of current position
     * @param direction - Direction of travel
     * @param path - Path taken so far
     * @return path - Returns path after reaching finish.
     */
    public ArrayList<Square> move(Square postition, Direction direction, ArrayList<Square> path) {
        if (maze.reachedFinish(postition)) {
            System.out.println("reached finish");
            return path;
        }
        path.add(postition);

        // Placeholder
        return null;
    }

    /**
     * Method for checking if it's possible to move from square to given
     * direction.
     *
     * @param square - Square of reference
     * @param direction - Direction that is checked
     * @return Boolean - true if square in direction is possible to traverse to
     */
    public boolean canMove(Square square, Direction direction) {
        int row = square.getHeight();
        int col = square.getWidth();

        if (direction == Direction.UP) {
            return maze.canMoveTo(col, row - 1);
        }
        if (direction == Direction.DOWN) {
            return maze.canMoveTo(col, row + 1);
        }
        if (direction == Direction.RIGHT) {
            return maze.canMoveTo(col + 1, row);
        }
        if (direction == Direction.LEFT) {
            return maze.canMoveTo(col - 1, row);
        }
        return false;
    }

    /**
     * Returns right hand direction of the given direction in relation to the
     * maze.
     *
     * @param direction - direction currently traversed
     * @return directionToRight - right hand direction of given direction
     */
    public Direction getDirectionToRight(Direction direction) {
        if (direction == Direction.UP) {
            return Direction.RIGHT;
        }
        if (direction == Direction.DOWN) {
            return Direction.LEFT;
        }
        if (direction == Direction.RIGHT) {
            return Direction.DOWN;
        }
        return Direction.UP;

    }

    /**
     * Returns left hand direction of the given direction in relation to the
     * maze.
     *
     * @param direction - direction currently traversed
     * @return directionToLeft - left hand direction of given direction
     */
    public Direction getDirectionToLeft(Direction direction) {
        if (direction == Direction.UP) {
            return Direction.LEFT;
        }
        if (direction == Direction.DOWN) {
            return Direction.RIGHT;
        }
        if (direction == Direction.RIGHT) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }

    /**
     * Return counter clockwise rotation of given direction, useful when facing
     * a dead end inside the maze.
     *
     * @param direction - current direction
     * @return direction - rotated direction
     */
    public Direction rotate(Direction direction) {
        if (direction == Direction.UP) {
            return Direction.LEFT;
        }
        if (direction == Direction.DOWN) {
            return Direction.RIGHT;
        }
        if (direction == Direction.RIGHT) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }

    /*
    
    Model reference
    
    traverse(Position p, Direction d, String pathSoFar)
   if atEndPosition(p)
     return pathSoFar + p;

   if canTravelRight(p, d)
      result = traverse(poitionToRight, directionToRight, pathSoFar + p)
      if result return result
   if canTravelForward(p, d)
      result = traverse(positionForward, d, pathSoFar + p)
      if result return result
   if canTravelLeft(p, d)
      result = traverse(positionToLeft, directionToLeft, pathSoFar + p)
   return result
    
     */
}
