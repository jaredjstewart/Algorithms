package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

import java.util.stream.IntStream;



/**
 * Weighted Lazy approach to union_find
 * (For union(a,b) , instead of attaching trees in the order given, always attach the smaller tree to the larger tree)
 *
 * <p>
 * Cost (worse-case):
 * initialize: N
 * union: lg N
 * find: lg N
 * <p>
 */
public class WeightedQuickUnion implements UnionFind {

    // Interpretation: id[i] is a parent of i
    int[] id;
    int[] sizeOfTreeRootedAt;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        sizeOfTreeRootedAt = new int[n];
        IntStream.range(0, n).forEach(val -> {
            id[val] = val;
            sizeOfTreeRootedAt[val] = val;
        }); //(N array accesses)
    }

    private int findRootOf(int i) {
        while (i != id[i]) i = id[i]; //depth of i array accesses
        return i;
    }

    @Override
    public boolean connected(int a, int b) {
        return findRootOf(a) == findRootOf(b);
    }

    /**
     * Change the root of a to point to the root of b
     * (depth of a and b array accesses)
     */
    @Override
    public void union(int a, int b) {
        int i = findRootOf(a);
        int j = findRootOf(b);
        if (i == j) return;
        if (sizeOfTreeRootedAt[i] < sizeOfTreeRootedAt[j]) {
            id[i] = j;
            sizeOfTreeRootedAt[j] += sizeOfTreeRootedAt[i];
        } else {
            id [j] = i;
            sizeOfTreeRootedAt[i] += sizeOfTreeRootedAt[j];
        }
    }

}

