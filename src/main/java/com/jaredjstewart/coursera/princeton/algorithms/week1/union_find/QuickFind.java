package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

import java.util.stream.IntStream;

/**
 * Eager approach to quick-find
 *
 * Cost:
 *  initalize: N
 *  union: N
 *  find/connected: 1
 *
 *  Note that N union commands on N objects (all objects connected) takes N^2 time.  (VERY BAD!!)
 *
 * Problems:
 *  Union too expensive (N array accesses).
 *  Trees are flat, but too expensive to keep them flat.
 *
 * */
public class QuickFind implements UnionFind {

    // Interpretation: id[i] means i is in the connected component of id[i]
    private int[] id;

    public QuickFind (int n){
        id = new int[n];
        IntStream.range(0,n).forEach(val -> id[val] = val); //(N array accesses)
    }


    /**
     * Change all elements in the connected component of a to be in the component of b
     */
    @Override
    public void union(int a, int b) {
        int idOfA = id[a];
        int idOfB = id[b];

       for (int i =0; i < id.length; i++) { //(at most 2N +2 array accesses)
           if (id[i] == idOfA) {
               id[i] = idOfB;
           }
       }
    }

    /**
     *Find whether a and b are in the same connected component
     */
    @Override
    public boolean connected(int a, int b) {
        return id[a] == id[b];  //(2 array accesses)
    }
}
