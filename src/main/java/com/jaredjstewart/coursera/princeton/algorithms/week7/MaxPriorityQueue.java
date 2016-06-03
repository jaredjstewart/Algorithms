package com.jaredjstewart.coursera.princeton.algorithms.week7;


public interface MaxPriorityQueue<Key> {
    void insert (Key key);

    /**
     * Deletes and returns the largest Key in this MaxPriorityQueue.
     * @return the largest Key in this MaxPriorityQueue
     */
    Key deleteMax();

    boolean isEmpty();
}
