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
     * Creates a NanoTimer
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

    public void setStartCurrent() {
        this.start = System.nanoTime();
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void setEndCurrent() {
        this.end = System.nanoTime();
    }

    public long getNanoSeconds() {
        return end - start;
    }

    public int getMilliSeconds() {
        long result = end - start;

        return (int) (result / 10000000);
    }

    public void clear() {
        this.start = 0;
        this.end = 0;
    }

    @Override
    public String toString() {
        if (start == 0 && end == 0) {
            return "No time yet";
        }
        return "" + getNanoSeconds() + " nano seconds.";
    }

}
