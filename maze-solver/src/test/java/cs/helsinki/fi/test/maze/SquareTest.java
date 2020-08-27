package cs.helsinki.fi.test.maze;

import cs.helsinki.fi.maze.Square;
import org.junit.BeforeClass;
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
    public void testToString() {
        Square square = new Square(2, 4);
        assertEquals("Square (2,4)", square.toString());
    }
}
