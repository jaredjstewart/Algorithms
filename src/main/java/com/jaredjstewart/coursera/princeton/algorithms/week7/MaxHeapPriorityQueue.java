package com.jaredjstewart.coursera.princeton.algorithms.week7;


import java.util.Comparator;


public class MaxHeapPriorityQueue<Key> implements MaxPriorityQueue<Key> {
    private Key[] priorityQueue;
    private int numberOfItemsInQueue;
    private Comparator<Key> comparator;

    public MaxHeapPriorityQueue(int initCapacity) {
        priorityQueue = (Key[]) new Object[initCapacity + 1];
        numberOfItemsInQueue = 0;
    }

    public MaxHeapPriorityQueue(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        priorityQueue = (Key[]) new Object[initCapacity + 1];
        numberOfItemsInQueue = 0;
    }


    @Override
    public void insert(Key key) {
        priorityQueue[++numberOfItemsInQueue] = key;
        swim(numberOfItemsInQueue);
    }

    @Override
    public Key deleteMax() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }




    /**
     * This is a helper method to restore the heap property when a child key has become larger than its parent.
     * @param k The index of the key which is larger than its parent key
     */
    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            exchange(k,k/2);
            k = k/2;
        }
    }

    /**
     * This is a helper method to restor the heap property when a parent node has become smaller than one or both of its children.
     * @param k The index of the key which is smaller than one or both of its children
     */
    private void sink(int k)
    {
        while (2*k <= numberOfItemsInQueue) {
            int smallestChildOfK = smallestChildOf(k);
            if (!less(k,smallestChildOfK)) break;

            exchange(k,smallestChildOfK);
            k=smallestChildOfK;
        }
    }

    private int smallestChildOf(int k) {
        int j = 2 * k;
        if (j < numberOfItemsInQueue && less(j, j+1)) j++;

        return j;
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) priorityQueue[i]).compareTo(priorityQueue[j]) < 0;
        }
        else {
            return comparator.compare(priorityQueue[i], priorityQueue[j]) < 0;
        }
    }

    private void exchange(int i, int j) {
        Key swap = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = swap;
    }
}
