package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

import java.util.stream.IntStream;

/**
 * Lazy approach to union_find
 *
 * Cost (worse-case):
 *  initialize: N
 *  union: N
 *  find: N
 *
 * Problems:
 *  Trees can get tall.
 *  Find too expensive (could be N array accesses).
 */
public class QuickUnion  implements UnionFind{

    // Interpretation: id[i] is a parent of i
    int[] id;

    public QuickUnion (int n){
       id = new int[n];
        IntStream.range(0,n).forEach(val -> id[val] = val); //(N array accesses)
    }

    private int findRootOf (int i) {
        while (i != id[i]) i = id[i]; //depth of i array accesses
        return i;
    }

    @Override
    public boolean connected(int a, int b) {
        return findRootOf(a) == findRootOf(b);
    }

    /**
     *  Change the root of a to point to the root of b
     *  (depth of a and b array accesses)
     */
    @Override
    public void union(int a, int b) {
        int i = findRootOf(a);
        int j = findRootOf(b);

        id[i] = j;
    }

}
