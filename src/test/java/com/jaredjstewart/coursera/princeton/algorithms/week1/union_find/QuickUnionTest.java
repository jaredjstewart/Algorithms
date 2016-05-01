package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

public class QuickUnionTest extends UnionFindTest{

    @Override
    protected UnionFind createInstance(int n) {
        return new QuickUnion(n);
    }
}