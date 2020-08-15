package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;
import java.util.ArrayList;

/**
 * Wall Follower algorithm.
 *
 * @author Ville Manninen
 */
public class WallFollower {

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
     *
     * @return Path - returns the path traversed
     */
    public ArrayList<Square> solve() {
        Square start = maze.getStart();
        ArrayList<Square> path = new ArrayList<>();

        move(start, Direction.DOWN, path);

        maze.setSquareValue(start.getWidth(), start.getHeight(), 3);

        return path;
    }

    /**
     * Used to move in wanted direction, will continue moving recursively before
     * reaching finish.
     *
     * @param pos - Square of current position
     * @param dir - Direction of travel
     * @param path - Path taken so far
     */
    public void move(Square pos, Direction dir, ArrayList<Square> path) {

        // Reached finish
        if (maze.reachedFinish(pos)) {
            maze.setSquareValue(pos.getWidth(), pos.getHeight(), 2);
            return;
        }
        // Mark if not at start
        if (maze.getStart() != pos) {
            maze.setSquareValue(pos.getWidth(), pos.getHeight(), 2);
        }
        // Can move right
        if (canMove(pos, getDirectionToRight(dir))) {
            Direction newDir = getDirectionToRight(dir);
            Square right = getSquareInDirection(pos, newDir);
            path.add(right);
            move(right, newDir, path);
            return;

        }
        // Can move forward
        if (canMove(pos, getDirectionToForward(dir))) {
            Direction newDir = getDirectionToForward(dir);
            Square forward = getSquareInDirection(pos, newDir);
            path.add(forward);
            move(forward, newDir, path);
            return;

        }
        // Can move left
        if (canMove(pos, getDirectionToLeft(dir))) {
            Direction newDir = getDirectionToLeft(dir);
            Square left = getSquareInDirection(pos, newDir);
            path.add(left);
            move(left, newDir, path);

        } else { // Rotate counter clockwise
            Square back = getSquareInDirection(pos, reverse(dir));
            move(back, reverse(dir), path);
        }
    }

    /**
     * Returns the next square in given direction of the current position.
     *
     * @param pos - current position
     * @param dir - direction of the next square
     * @return Square - neighbouring square in given direction
     */
    public Square getSquareInDirection(Square pos, Direction dir) {
        int col = pos.getWidth();
        int row = pos.getHeight();
        if (dir == Direction.UP) {
            return new Square(col, row - 1);
        }
        if (dir == Direction.DOWN) {
            return new Square(col, row + 1);
        }
        if (dir == Direction.RIGHT) {
            return new Square(col + 1, row);
        }
        if (dir == Direction.LEFT) {
            return new Square(col - 1, row);
        }
        return null;
    }

    /**
     * Returns reverse direction of given direction
     *
     * @param dir - given direction
     * @return reverse - reverse direction
     */
    public Direction reverse(Direction dir) {
        if (dir == Direction.UP) {
            return Direction.DOWN;
        }
        if (dir == Direction.DOWN) {
            return Direction.UP;
        }
        if (dir == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.RIGHT;
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
        int col = square.getWidth();
        int row = square.getHeight();

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
     * Only for my peace of mind
     *
     * @param direction
     * @return
     */
    public Direction getDirectionToForward(Direction direction) {
        return direction;
    }

    /**
     * Rotates given direction counter clockwise.
     *
     * @param direction - current direction
     * @return direction - rotated direction
     */
    public Direction rotateLeft(Direction direction) {
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
}
