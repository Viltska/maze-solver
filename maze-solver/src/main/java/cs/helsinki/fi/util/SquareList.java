package cs.helsinki.fi.util;

import cs.helsinki.fi.maze.Square;

/**
 * ArrayList for storing Square class as items.
 *
 * @author Ville Manninen
 */
public class SquareList {

    private static Square[] list;
    private static int nextFree;

    /**
     * Creates a SquareList with initial size of 10.
     */
    public SquareList() {
        SquareList.list = new Square[10];
        nextFree = 0;

    }

    /**
     * Adds the given square to the list.
     *
     * @param s - Square that is added to the list
     */
    public void add(Square s) {
        list[nextFree] = s;
        nextFree++;

        if (nextFree == list.length) {
            resize();
        }
    }

    /**
     * Returns the number of Squares stored in the list.
     *
     * @return int - number of items
     */
    public int size() {
        return nextFree;
    }

    /**
     * Returns Square stored at the given index or returns null if out of bounds
     * or no stored Square.
     *
     * @param i - Index of the Square
     * @return Square - Returns the square at the index
     */
    public static Square getIndex(int i) {
        if (i >= nextFree || i < 0) {
            return null;
        }

        return list[i];
    }

    /**
     * Removes Square item in the given index.
     *
     * @param i - given index
     */
    public void remove(int i) {
        if (i >= 0 && i < nextFree) {
            list[i] = null;
            for (int j = i; j < list.length - 1; j++) {
                Square tmp = list[j + 1];
                list[j] = tmp;
                list[j + 1] = null;
            }
            nextFree--;
        }
    }

    /**
     * Returns true if there is no stored items on the list.
     *
     * @return Boolean - true if no stored items
     */
    public boolean isEmpty() {
        return nextFree == 0;
    }

    /**
     * Returns a random Square from the list.
     *
     * @return
     */
    public Square getRandom() {
        if (nextFree > -1) {
            if (nextFree == 1) {
                return list[0];
            }
            int rnd = (int) (System.nanoTime() * 1000) % (nextFree - 1);
            int i = rnd > 0 ? rnd : -rnd;
            return list[i];
        }
        return null;
    }

    /**
     * Doubles the size of the array and copies items to the new list, then
     * replaces the global list with the larger array.
     */
    private void resize() {
        Square[] newList = new Square[(list.length * 2)];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        SquareList.list = newList;
    }

    /**
     * String representation of the list.
     *
     * @return String - String including all the squares.toString().
     */
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < nextFree; i++) {
            s += list[i].toString() + " ";
        }
        s += "]";
        return s;
    }
}
