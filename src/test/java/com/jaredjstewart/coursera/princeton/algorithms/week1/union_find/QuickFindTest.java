package com.jaredjstewart.coursera.princeton.algorithms.week1.union_find;

public class QuickFindTest extends UnionFindTest {

    @Override
    protected UnionFind createInstance(int n) {
        return new QuickFind(n);
    }
}