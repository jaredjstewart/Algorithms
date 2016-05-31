package com.jaredjstewart.coursera.princeton.algorithms.week3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Queue</tt> class represents a firstItem-in-firstItem-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the firstItem item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a static nested class for
 *  linked-list nodes. See {@link LinkedQueue} for the version from the
 *  textbook that uses a non-static nested class.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 */
public class LinkedQueue<Item> implements Iterable<Item> {

        private int N;               // number of elements on queue
        private Node<Item> firstItem;    // beginning of queue
        private Node<Item> lastItem;     // end of queue

        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        public LinkedQueue() {
            firstItem = null;
            lastItem = null;
            N = 0;
        }

        public boolean isEmpty() {
            return firstItem == null;
        }

        public int size() {
            return N;
        }

        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            return firstItem.item;
        }

        public void enqueue(Item item) {
            Node<Item> oldlast = lastItem;
            lastItem = new Node<Item>();
            lastItem.item = item;
            lastItem.next = null;
            if (isEmpty()) firstItem = lastItem;
            else           oldlast.next = lastItem;
            N++;
        }

        public Item dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = firstItem.item;
            firstItem = firstItem.next;
            N--;
            if (isEmpty()) lastItem = null;  //Make sure we don't have a hanging object reference
            return item;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this)
                s.append(item).append(" ");
            return s.toString();
        }

        public Iterator<Item> iterator()  {
            return new ListIterator<Item>(firstItem);
        }

        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext()  { return current != null;                     }
            public void remove()      { throw new UnsupportedOperationException();  }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
}
