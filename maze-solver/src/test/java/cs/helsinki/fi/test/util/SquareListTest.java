/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.util;

import cs.helsinki.fi.maze.Square;
import cs.helsinki.fi.util.SquareList;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class SquareListTest {

    public SquareListTest() {

    }

    @Test
    public void isEmptyTest() {
        SquareList sl = new SquareList();
        assertEquals(true, sl.isEmpty());
        Square s1 = new Square(1, 1);
        sl.add(s1);
        assertEquals(false, sl.isEmpty());
    }

    @Test
    public void testAdd() {
        SquareList sl = new SquareList();
        sl.add(new Square(1, 1));
        assertEquals(1, sl.size());

    }

    @Test
    public void getTest() {
        SquareList sl = new SquareList();
        Square s1 = new Square(0, 0);
        Square s2 = new Square(1, 0);
        Square s3 = new Square(2, 0);

        sl.add(s1);
        sl.add(s2);
        sl.add(s3);

        assertEquals(s1, sl.getIndex(0));
        assertEquals(s2, sl.getIndex(1));
        assertEquals(s3, sl.getIndex(2));
        assertEquals(null, sl.getIndex(3));
        assertEquals(null, sl.getIndex(100));
        assertEquals(null, sl.getIndex(-1));

    }

    @Test
    public void removeTest() {
        SquareList sl = new SquareList();

        Square s1 = new Square(0, 0);
        Square s2 = new Square(1, 0);
        Square s3 = new Square(2, 0);

        sl.add(s1);
        sl.remove(0);
        assertEquals(true, sl.isEmpty());

        sl.add(s1);
        sl.add(s2);
        sl.add(s3);

        sl.remove(0);
        assertEquals(s2, sl.getIndex(0));
        assertEquals(s3, sl.getIndex(1));
        assertEquals(null, sl.getIndex(2));
        assertEquals(null, sl.getIndex(-1));
        assertEquals(null, sl.getIndex(100));
    }

    @Test
    public void resizeTest() {
        SquareList sl = new SquareList();

        for (int i = 0; i < 11; i++) {
            Square s = new Square(i, i);
            sl.add(s);
        }
        assertEquals(11, sl.size());
    }

    @Test
    public void toStringTest() {
        SquareList sl = new SquareList();
        assertEquals(false, sl.toString().isEmpty());
        sl.add(new Square(2, 5));
        assertEquals(true, sl.toString().contains("5"));
        assertEquals(true, sl.toString().contains("2"));
        assertEquals(true, sl.toString().contains("Square"));
    }
}
