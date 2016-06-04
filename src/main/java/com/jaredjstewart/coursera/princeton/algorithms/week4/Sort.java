package com.jaredjstewart.coursera.princeton.algorithms.week4;

public abstract class Sort {
     public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

     public static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
