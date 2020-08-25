package cs.helsinki.fi.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Random Integer generator class.
 *
 * @author Ville Manninen
 * @since 1.6
 */
public class RandomGenerator {

    /**
     * Creates a RandomGenerator.
     */
    public RandomGenerator() {

    }

    /**
     * Generates a int number between zero (inclusive) and given integer.
     *
     * @param limit - limit of the random number (exclusive)
     * @return int - generated random number
     */
    public int generate(int limit) {
        if (limit > 0) {
            return ThreadLocalRandom.current().nextInt(0, limit);
        }
        return 0;
    }

    /**
     * Generates a int number between two given integers, returned numbers can't
     * be negative.
     *
     * @param from - smallest possible number
     * @param to - largest possible number
     * @return int - generated random number
     */
    public int generateBetween(int from, int to) {
        if (-1 < from && from < to) {
            return ThreadLocalRandom.current().nextInt(from, to);
        }
        return 0;
    }
}
