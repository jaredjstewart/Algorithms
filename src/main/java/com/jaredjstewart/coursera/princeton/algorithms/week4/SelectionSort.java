package com.jaredjstewart.coursera.princeton.algorithms.week4;

/*Elementary O(n^2) sorting algorithm - in place comparison sort.
Selection sort uses ~1/2 N^2 compares and N exchanges on average.
Inefficient but useful when auxiliary memory is limited. */
public class SelectionSort extends Sort {
    public static void sort (Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j= i +1; j < N; j++){
                if (less(a[j], a[min]))
                    min = j;
            }
            exchange(a, i, min);
        }
    }
}
