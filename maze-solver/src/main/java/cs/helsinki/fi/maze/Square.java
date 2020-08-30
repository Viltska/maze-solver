package cs.helsinki.fi.maze;

/**
 * Class to hold maze coordinates.
 *
 * @author Ville Manninen
 */
public class Square{

    private int x;
    private int y;

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

    public void setWidth(int x) {
        this.x = x;
    }

    public void setHeight(int y) {
        this.y = y;
    }

    /**
     * Checks if given squares x and y match this squares x and y.
     *
     * @param square - square that is compared
     * @return Boolean - true if x and y is the same
     */
    public boolean equals(Square square) {
        return this.x == square.getWidth() && this.y == square.getHeight();
    }

    @Override
    public String toString() {
        return "Square (" + x + "," + y + ")";
    }
}
