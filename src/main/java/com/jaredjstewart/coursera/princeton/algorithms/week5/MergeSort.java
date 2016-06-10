package com.jaredjstewart.coursera.princeton.algorithms.week5;

import com.jaredjstewart.coursera.princeton.algorithms.week4.Sort;

public class MergeSort extends Sort {

        // merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
        private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            assert isSorted(a, lo, mid);
            assert isSorted(a, mid+1, hi);

            // copy to aux[]
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            // merge back to a[]
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)              a[k] = aux[j++];   // this copying is unnecessary
                else if (j > hi)               a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else                           a[k] = aux[i++];
            }

            assert isSorted(a, lo, hi);
        }

        // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }


        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];
            sort(a, aux, 0, a.length-1);
            assert isSorted(a);
        }

        private static boolean isSorted(Comparable[] a, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++)
                if (less(a[i], a[i-1])) return false;
            return true;
        }


}
