/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.util;

import cs.helsinki.fi.util.RandomGenerator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ville Manninen
 */
public class RandomGeneratorTest {

    public RandomGeneratorTest() {
    }

    @Test
    public void generateTest() {
        RandomGenerator r = new RandomGenerator();

        assertEquals(true, r.generate(3) >= 0);
        assertEquals(true, r.generate(3) < 3);
        assertEquals(true, r.generate(1) < 1);

        assertEquals(true, r.generate(1) >= 0);
        assertEquals(true, r.generate(0) == 0);
        assertEquals(true, r.generate(6) >= 0);
    }

    @Test
    public void generateBetweenTest() {
        RandomGenerator r = new RandomGenerator();

        assertEquals(true, r.generateBetween(0, 1) >= 0);
        assertEquals(true, r.generateBetween(0, 0) == 0);
        assertEquals(true, r.generateBetween(-1, 0) == 0);

        assertEquals(true, r.generateBetween(3, 6) >= 3);
        assertEquals(true, r.generateBetween(3, 6) < 6);
        assertEquals(true, r.generateBetween(3, 4) < 4);
        assertEquals(true, r.generateBetween(100, 101) >= 100);
        assertEquals(true, r.generateBetween(2, 1) == 0);

    }
}
