package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

public interface  UnionFind {

    /**
     * Connects a to b
     * @param a
     * @param b
     */
     void union(int a, int b);

    /**
     * returns true if a and b are connected
     * @param a
     * @param b
     * @return
     */
     boolean connected(int a, int b);
}
