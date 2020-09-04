package cs.helsinki.fi.util;

import cs.helsinki.fi.maze.Square;

/**
 * Holds Square values in a queue.
 *
 * @author Ville Manninen
 */
public class SquareQueue {

    private Node first;
    private Node last;

    /**
     * Creates an empty queue.
     */
    public SquareQueue() {

    }

    /**
     * Adds a Square to the queue.
     *
     * @param s - Square that is added
     */
    public void add(Square s) {
        if (first == null) {
            Node n = new Node(s);
            first = n;
            last = n;
        } else {
            Node n = new Node(s);
            last.setNext(n);
            last = n;
        }
    }

    /**
     * Returns and removes the first Square from the queue.
     *
     * @return s - First Square of the queue.
     */
    public Square pop() {
        if (first.getNext() != null) {
            Square s = first.getSquare();
            Node temp = first.getNext();
            first = null;
            first = temp;
            return s;
        }
        Square s = first.getSquare();
        first = null;
        return s;
    }

    /**
     * Returns but doesn't remove the first Square of the queue.
     *
     * @return Square - returns the first Square of the queue
     */
    public Square peek() {
        return first.getSquare();
    }

    /**
     * Returns the last element of the list but doesn't remove it.
     *
     * @return Square - the last square of the queue
     */
    public Square peekLast() {
        return this.last.getSquare();
    }

    /**
     * Returns true if the SquareQue has no elements stored.
     *
     * @return Boolean - Returns true if no elements stored.
     */
    public boolean isEmpty() {
        return first == null;
    }
}

/**
 * Node class that holds information of a single Square and the Node behind it
 * in the queue.
 *
 */
class Node {

    private final Square s;
    private Node next;

    /**
     * Creates a Node with a Square value.
     *
     * @param s - Square that is assigned to this Node.
     */
    public Node(Square s) {
        this.s = s;
    }

    /**
     * Sets the node behind.
     *
     * @param node - Node that is stored as next.
     */
    public void setNext(Node node) {
        this.next = node;
    }

    /**
     * Returns the node that is behind.
     *
     * @return node - Node that is behind
     */
    public Node getNext() {
        return next;
    }

    /**
     * Returns the Square that is assigned to this Node.
     *
     * @return square - Square that is assigned to this node.
     */
    public Square getSquare() {
        return this.s;
    }
}
