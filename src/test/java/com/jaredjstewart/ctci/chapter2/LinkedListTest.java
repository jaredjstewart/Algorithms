package com.jaredjstewart.ctci.chapter2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LinkedListTest {

    @Test
    public void findKthToLastElementTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i < 6; i++) {
            linkedList.insert(i);
        }

        assertTrue(linkedList.findKthToLastElement(3) == 3);
        assertTrue(linkedList.findKthToLastElement(2) == 4);
        assertTrue(linkedList.findKthToLastElement(1) == 5);
    }
}