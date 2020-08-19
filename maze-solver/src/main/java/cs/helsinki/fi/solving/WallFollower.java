package cs.helsinki.fi.solving;

import cs.helsinki.fi.maze.*;
import cs.helsinki.fi.util.SquareList;

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
     * Finds a recursive solution for the given maze and returns a SquareList
     * containing the path.
     *
     * @return Path - the path traversed
     */
    public SquareList solveRecursive() {
        Square start = maze.getStart();
        SquareList path = new SquareList();
        move(start, Direction.DOWN, path);

        maze.setSquareValue(start.getWidth(), start.getHeight(), 3);

        return path;
    }

    /**
     * Finds a solution without recursion for the given maze and returns a
     * SquareList containing the path.
     *
     * @return Path - the path traversed
     */
    public SquareList solve() {
        Square current = maze.getStart();
        Direction dir = Direction.DOWN;
        SquareList path = new SquareList();

        while (!maze.reachedFinish(current)) {
            if (canMove(current, getDirectionToRight(dir))) {
                Direction newDir = getDirectionToRight(dir);
                Square right = getSquareInDirection(current, newDir);
                path.add(right);
                current = right;
                dir = newDir;

            } else if (canMove(current, dir)) {
                Square forward = getSquareInDirection(current, dir);
                path.add(forward);
                current = forward;

            } else if (canMove(current, getDirectionToLeft(dir))) {
                Direction newDir = getDirectionToLeft(dir);
                Square left = getSquareInDirection(current, newDir);
                path.add(left);
                current = left;
                dir = newDir;

            } else {
                Direction newDir = reverse(dir);
                Square back = getSquareInDirection(current, reverse(dir));
                path.add(back);
                current = back;
                dir = newDir;
            }
        }
        return path;
    }

    /**
     * Used to move in wanted direction, will continue moving recursively before
     * reaching finish.
     *
     * @param pos - Square of current position
     * @param dir - Direction of travel
     * @param path - Path taken so far
     * @return SquareList - List of the path
     */
    public SquareList move(Square pos, Direction dir, SquareList path) {
        if (maze.reachedFinish(pos)) {
            path.add(pos);
            return path;
        }

        if (canMove(pos, getDirectionToRight(dir))) {
            Direction newDir = getDirectionToRight(dir);
            Square right = getSquareInDirection(pos, newDir);
            path.add(right);
            return move(right, newDir, path);

        } else if (canMove(pos, dir)) {
            Square forward = getSquareInDirection(pos, dir);
            path.add(forward);
            return move(forward, dir, path);

        } else if (canMove(pos, getDirectionToLeft(dir))) {
            Direction newDir = getDirectionToLeft(dir);
            Square left = getSquareInDirection(pos, newDir);
            path.add(left);
            return move(left, newDir, path);

        } else {
            Square back = getSquareInDirection(pos, reverse(dir));
            return move(back, reverse(dir), path);
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
     * Returns reverse direction of given direction.
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
     * Rotates given direction counter clockwise.
     *
     * @param direction - current direction
     * @return returned direction - rotated direction
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
