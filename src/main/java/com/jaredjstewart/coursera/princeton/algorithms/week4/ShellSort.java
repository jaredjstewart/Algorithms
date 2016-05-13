package com.jaredjstewart.coursera.princeton.algorithms.week4;

/*
The worst-case number of compares used by shellsort with the 3x+1 increment is O(N ^ (3/2))
 Fast unless array size is huge.  Small, fixed footprint for code (embedded systems)
 The best sequence of increments is an open problem and there is no complete model yet for average-case performance.
 */
public class ShellSort extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int gap = findLargestGapValueForArrayOfSize(N);

        while (gap >= 1)
        {
            //gap-sort the array
            for (int i=gap; i < N; i++) {
                for (int j=i; j >= gap && less(a[j], a[j - gap]); j -= gap) {
                  exchange(a, j, j - gap);
                }
            }
            gap = gap / 3;
        }

    }

    /* We use the sequence k = (3k + 1) as our gap sequence.
    @returns The largest value of the sequence (3^k - 1) / 2 not greater than floor(N/3)
     */
    private static int findLargestGapValueForArrayOfSize (int N) {
        int gap=1;
        while (gap < N/3) gap = 3*gap + 1; //1, 4, 13, 40, 121 (3x + 1 sequence)
        return gap;
    }
}
