package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;
import cs.helsinki.fi.util.SquareQueue;

/**
 * Wall Follower algorithm.
 *
 * @author Ville Manninen
 */
public class WallFollower {

    private static Maze maze;

    /**
     * Creates a instance of WallFollower class.
     *
     * @param maze - Maze that the algorithm will use
     */
    public WallFollower(Maze maze) {
        WallFollower.maze = maze;
    }

    /**
     * Finds a recursive solution for the given maze and returns a SquareList
     * containing the path.
     *
     * @return Path - the path traversed
     */
    public SquareQueue solveRecursive() {
        Square start = maze.getStart();
        SquareQueue path = new SquareQueue();

        move(start, Direction.DOWN, path);

        maze.setSquareValue(start.getWidth(), start.getHeight(), 3);

        return path;
    }

    /**
     * Finds a iterative solution for the given maze and returns a SquareQue
     * containing the path traversed.
     *
     * @return Path - the path traversed
     */
    public SquareQueue solve() {
        Square current = maze.getStart();
        Direction dir = Direction.DOWN;
        SquareQueue path = new SquareQueue();

        while (!maze.reachedFinish(current)) {
            if (canMove(current, getDirectionToRight(dir))) {
                Direction newDir = getDirectionToRight(dir);
                current = getSquareInDirection(current, newDir);
                dir = newDir;
                path.add(current);

            } else if (canMove(current, dir)) {
                current = getSquareInDirection(current, dir);
                path.add(current);

            } else if (canMove(current, getDirectionToLeft(dir))) {
                Direction newDir = getDirectionToLeft(dir);
                current = getSquareInDirection(current, newDir);
                dir = newDir;
                path.add(current);

            } else {
                Direction newDir = reverse(dir);
                current = getSquareInDirection(current, reverse(dir));
                dir = newDir;
                path.add(current);

            }
        }
        return path;
    }

    /**
     * Used to move in wanted direction, will continue moving recursively until
     * reaching a square nest to mazes finish square.
     *
     * @see solveRecursive
     * @param pos - Square of current position
     * @param dir - Direction of current travel
     * @param path - Path taken so far
     * @return SquareQue - List of the path traversed (after reaching finish)
     */
    public SquareQueue move(Square pos, Direction dir, SquareQueue path) {
        if (maze.reachedFinish(pos)) {
            path.add(pos);
            return path;
        }

        if (canMove(pos, getDirectionToRight(dir))) {
            pos = getSquareInDirection(pos, getDirectionToRight(dir));
            path.add(pos);
            return move(pos, getDirectionToRight(dir), path);

        } else if (canMove(pos, dir)) {
            pos = getSquareInDirection(pos, dir);
            path.add(pos);
            return move(pos, dir, path);

        } else if (canMove(pos, getDirectionToLeft(dir))) {
            pos = getSquareInDirection(pos, getDirectionToLeft(dir));
            path.add(pos);
            return move(pos, getDirectionToLeft(dir), path);

        } else {
            pos = getSquareInDirection(pos, reverse(dir));
            return move(pos, reverse(dir), path);
        }

    }

    /**
     * Returns the next square in given direction of the current position.
     *
     * @param pos - current position
     * @param dir - direction of the next square
     * @return Square - the square in given direction
     */
    public static Square getSquareInDirection(Square pos, Direction dir) {
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
     * Returns reverse direction of given direction.
     *
     * @param dir - given direction
     * @return reverse - reverse direction
     */
    public static Direction reverse(Direction dir) {
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
    public static boolean canMove(Square square, Direction direction) {
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
    public static Direction getDirectionToRight(Direction direction) {
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
    public static Direction getDirectionToLeft(Direction direction) {
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
     * Rotates given direction counter clockwise.
     *
     * @param direction - current direction
     * @return returned direction - rotated direction
     */
    public static Direction rotateLeft(Direction direction) {
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
