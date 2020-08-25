/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.helsinki.fi.test.util;

import cs.helsinki.fi.util.Timer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ville Manninen
 */
public class TimerTest {

    public TimerTest() {
    }

    @Test
    public void getResultTest() {
        Timer timer = new Timer();
        timer.setStart(10000000);
        timer.setEnd(20000000);

        assertEquals(1, timer.getMilliSeconds());
        assertEquals(10000000, timer.getNanoSeconds());
        
    }
}
