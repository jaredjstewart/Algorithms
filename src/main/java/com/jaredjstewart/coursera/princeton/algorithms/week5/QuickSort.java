package com.jaredjstewart.coursera.princeton.algorithms.week5;

import com.jaredjstewart.coursera.princeton.algorithms.week4.Sort;
import edu.princeton.cs.introcs.StdRandom;

import java.util.Scanner;

public class QuickSort extends Sort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); //Shuffle needed for probabilistic guarantee on runtime
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * Modifies the array <tt>a</tt> to be partitioned by a[lo].
     *
     * @param a  The array to be partitioned.
     * @param lo The start index of partitioning
     * @param hi The end index of partitioning
     * @returns The index of the partitioning element (which is now known to be in place)
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }

            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner  = new Scanner(System.in);

        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < Math.pow(size, 2); i++) {
            matrix[i / size][i % size] = scanner.nextInt();
        }

        int main = 0, second = 0;
        for (int i = 0; i < size; i++) {
            System.out.println(String.valueOf(matrix[i][i]));
            System.out.println(String.valueOf(matrix[size- i - 1][size - i - 1]));
            main += matrix[i][i];
            second += matrix[size- i - 1][size - i - 1];
        }

        int unsignedDiff =  Math.abs(main - second);
        System.out.println(String.valueOf(unsignedDiff));

    }
}
