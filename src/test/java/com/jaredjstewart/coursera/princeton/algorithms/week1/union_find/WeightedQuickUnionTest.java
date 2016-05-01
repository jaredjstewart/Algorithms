package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

public class WeightedQuickUnionTest extends UnionFindTest {

    @Override
    protected UnionFind createInstance(int n) {
        return new WeightedQuickUnion(n);
    }
}