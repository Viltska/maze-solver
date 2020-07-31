package cs.helsinki.fi.maze;

/**
 * Class to hold maze coordinates.
 *
 * @author Ville Manninen
 */
public class Square {

    private final int x;
    private final int y;

    /**
     * Creates a Pair of values.
     *
     * @param x - width coordinate
     * @param y - height coordinate
     */
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return this.x;

    }

    public int getHeight() {
        return this.y;

    }

    @Override
    public String toString() {
        return "Square (" + x + "," + y + ")";
    }
}
