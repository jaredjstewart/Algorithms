package com.jaredjstewart.coursera.princeton.algorithms.week4;

import java.util.Random;

public class ShuffleSort {

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that <tt>Math.random()</tt> generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be shuffled
     */
    public static void shuffle(Object[] a) {
        Random random = new Random();

        int N = a.length;
        for (int i = 0; i < N; i++) {
            // choose index uniformly in [i, N-1]
            int r = random.ints(0,  i + 1).findFirst().getAsInt();
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

}
