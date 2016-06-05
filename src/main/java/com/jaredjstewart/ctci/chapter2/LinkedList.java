package com.jaredjstewart.ctci.chapter2;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>
{
    Node<Item> head;

    public void insert(Item item){
        Node<Item> nodeToInsert =  new Node<Item>(item);
        if (head == null) head = nodeToInsert;
        else {
            findEndNode().next = nodeToInsert;
        }
    }


    public static class Node<Item> {
        Node<Item> next;
        Item item;

        public Node(Item item) {
            this.item = item;
        }
    }

    public Item findKthToLastElement(int k) {
        assert k > 0;

        // left pointer will stay k - 1 elements behind right
        Node<Item> left = head;
        Node<Item> right = head;

        for (int i = 1; i < k; i++ ){
            if (right.next == null) return null;
            right = right.next;
        }

        while(right.next != null) {
            right = right.next;
            left = left.next;
        }

        return left.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> node = head;

            @Override
            public boolean hasNext() {
                return node != null && node.next != null;
            }

            @Override
            public Item next() {
                Item item = node.item;
                node = node.next;
                return item;
            }
        };
    }

    private Node<Item> findEndNode() {
        if (head == null || head.next == null) return head;

        Node<Item> traversalNode = head.next;
        while (traversalNode.next != null) {
            traversalNode = traversalNode.next;
        }
        return traversalNode;
    }

}
