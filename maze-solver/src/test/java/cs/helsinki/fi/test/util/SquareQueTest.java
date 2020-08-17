/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.util;

import cs.helsinki.fi.maze.Square;
import cs.helsinki.fi.util.SquareQue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class SquareQueTest {

    public SquareQueTest() {
    }

    @Test
    public void initTest() {
        SquareQue sq = new SquareQue();
        assertEquals(true, sq.isEmpty());

    }

    @Test
    public void addTest() {
        SquareQue sq = new SquareQue();
        Square s = new Square(0, 0);
        sq.add(s);

        assertEquals(false, sq.isEmpty());
        assertEquals(s, sq.peek());

    }

    @Test
    public void removeTest() {
        SquareQue sq = new SquareQue();
        Square s = new Square(0, 0);
        sq.add(s);
        assertEquals(false, sq.isEmpty());

        sq.pop();

        assertEquals(true, sq.isEmpty());

    }

    @Test
    public void linkedTest() {
        SquareQue sq = new SquareQue();

        Square s1 = new Square(1, 0);
        Square s2 = new Square(2, 0);
        Square s3 = new Square(3, 0);
        Square s4 = new Square(4, 0);

        sq.add(s1);
        sq.add(s2);
        sq.add(s3);
        sq.add(s4);

        assertEquals(s1, sq.pop());
        assertEquals(s2, sq.pop());
        assertEquals(s3, sq.pop());
        assertEquals(s4, sq.pop());

        assertEquals(true, sq.isEmpty());
    }
}
