package com.jaredjstewart.coursera.princeton.algorithms.week8;


public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

   private class Node {
        Key key;
        Value value;
        int count;
        Node left,right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int comparisonResult = key.compareTo(node.key);
            if (comparisonResult < 0) node = node.left;
            else if (comparisonResult > 0) node = node.right;
            else if (comparisonResult == 0 ) return node.value;
        }
        put (null, null, null);

        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
    Insert <code>key, value</code> into the subtree with root <code>node</code>, and return a pointer to the root of
    the resulting subtree.
     **/
    private Node put (Node node, Key key, Value value) {
        if (node == null) return new Node (key,  value);
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) node.left = put (node.left, key, value);
        else if (comparisonResult > 0) node.right = put (node.right, key, value);
        else if (comparisonResult == 0) node.value = value;

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Key floor(Key key) {
        Node node = floor(root,key);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int comparisonResult = key.compareTo(node.key);

        if (comparisonResult == 0) return node;

        if (comparisonResult < 0) return floor(node.left, key);

        Node  floorFromRightSubtree = floor(node.right ,key);
        if (floorFromRightSubtree != null) return floorFromRightSubtree;
        else return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    /**
     * Computes the number of keys <code>< k </code>
     * @param key The key
     * @return The number of keys less than <code>key</code>.
     */
    public int rank (Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) return rank(key, node.left);
        else if (comparisonResult > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left); // if (comparisonResult == 0)
    }



}
