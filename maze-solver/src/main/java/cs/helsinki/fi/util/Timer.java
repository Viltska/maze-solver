package cs.helsinki.fi.util;

/**
 * Timer to measure execution time.
 *
 * @author Ville Manninen
 */
public class Timer {

    private long start;
    private long end;

    /**
     * Creates a Timer with start and end set at 0.
     */
    public Timer() {
        this.start = 0;
        this.end = 0;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    /**
     * Starts the timer at current system time.
     */
    public void start() {
        this.start = System.nanoTime();
    }

    /**
     * Ends the timer at current system time.
     */
    public void end() {
        this.end = System.nanoTime();
    }

    /**
     * Returns the time measured by the timer in nanoseconds.
     *
     * @return long - result (end - start)
     */
    public long getNanoSeconds() {
        if (start != 0 && end != 0) {
            return end - start;
        }
        return 0;
    }

    /**
     * Returns the time measured by the timer in milliseconds.
     *
     * @return int - result ((end - start) / 1000000)
     */
    public int getMilliSeconds() {
        if (start != 0 && end != 0) {
            long result = end - start;
            return (int) (result / 1000000);
        }
        return 0;
    }

    /**
     * Clears the values stored.
     */
    public void clear() {
        this.start = 0;
        this.end = 0;
    }

    /**
     * If time is measured returns the result in milliseconds.
     *
     * @return String - result in milliseconds as a String
     */
    @Override
    public String toString() {
        if (start == 0 && end == 0) {
            return "No time yet";
        }
        return "" + getMilliSeconds() + " ms.";
    }

}
