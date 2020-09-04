package cs.helsinki.fi.test.maze;

import cs.helsinki.fi.maze.Square;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class SquareTest {

    public SquareTest() {
    }

    @Test
    public void testPair() {
        Square square = new Square(2, 4);
        int x = square.getWidth();
        int y = square.getHeight();

        assertEquals(2, x);
        assertEquals(4, y);
    }

    @Test
    public void testEquals() {
        Square square = new Square(1, 1);
        Square square2 = new Square(1, 2);
        Square square3 = new Square(2, 1);
        Square square4 = new Square(0, 0);

        Square squareTrue = new Square(1, 1);

        assertEquals(true, square.equals(squareTrue));

        assertEquals(false, square.equals(square2));
        assertEquals(false, square.equals(square3));
        assertEquals(false, square.equals(square4));

    }

    @Test
    public void testToString() {
        Square square = new Square(2, 4);
        assertEquals("Square (2,4)", square.toString());
    }
}
