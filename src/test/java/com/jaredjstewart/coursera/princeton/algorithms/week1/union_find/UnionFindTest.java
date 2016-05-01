package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class UnionFindTest {

    private UnionFind unionFind;

    protected abstract UnionFind createInstance(int n);

    @Test
    public void testTwoItemsNoConnection() {
        unionFind = createInstance(2);
        assertFalse(unionFind.connected(0,1));
    }

    @Test
    public void testTwoItemsWithConnection() {
        unionFind = createInstance(2);
        unionFind.union(0,1);
        assertTrue(unionFind.connected(0,1));
    }

}