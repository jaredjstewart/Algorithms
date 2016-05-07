package com.jaredjstewart.coursera.princeton.algorithms.week3;

/* Insertion sort uses ~1/4 N^2 compares and ~1/4 N^2 exchanges on average
* Best case: N-1 compares, 0 exchanges.
* Worst case: ~1/2 N^2 compares, ~1/2 N^2 exchanges.
* For partially-sorted arrays, insertion sort runs in linear time.
* */
public class InsertionSort extends Sort {
    public static void sort(Comparable[] a) {
    int N = a.length;
        for (int i=0; i < N; i ++)
            for (int j=i; j > 0; j--)
                if (less(a[j], a[j-1]))
                    exchange(a, j, j-1);
                else break;
    }
}
