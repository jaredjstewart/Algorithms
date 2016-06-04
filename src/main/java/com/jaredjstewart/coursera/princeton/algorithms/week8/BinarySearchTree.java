package com.jaredjstewart.coursera.princeton.algorithms.week8;


import com.jaredjstewart.coursera.princeton.algorithms.week3.LinkedQueue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    BinaryTreeNode root;

    class BinaryTreeNode {
        Key key;
        Value value;
        int count;
        BinaryTreeNode left,right;

        public BinaryTreeNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public Value get(Key key) {
        BinaryTreeNode node = root;
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
    BinaryTreeNode put (BinaryTreeNode node, Key key, Value value) {
        if (node == null) return new BinaryTreeNode(key,  value);
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) node.left = put (node.left, key, value);
        else if (comparisonResult > 0) node.right = put (node.right, key, value);
        else if (comparisonResult == 0) node.value = value;

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Key floor(Key key) {
        BinaryTreeNode node = floor(root,key);
        if (node == null) return null;
        return node.key;
    }

    BinaryTreeNode floor(BinaryTreeNode node, Key key) {
        if (node == null) return null;
        int comparisonResult = key.compareTo(node.key);

        if (comparisonResult == 0) return node;

        if (comparisonResult < 0) return floor(node.left, key);

        BinaryTreeNode floorFromRightSubtree = floor(node.right ,key);
        if (floorFromRightSubtree != null) return floorFromRightSubtree;
        else return node;
    }

    public int size() {
        return size(root);
    }

    int size(BinaryTreeNode x) {
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

    int rank(Key key, BinaryTreeNode node) {
        if (node == null) return 0;
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) return rank(key, node.left);
        else if (comparisonResult > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left); // if (comparisonResult == 0)
    }

    public Iterable<Key> keys(){
        LinkedQueue<Key> q = new LinkedQueue<Key>();
        inorder(root,q);
        return q;
    }

    void inorder(BinaryTreeNode node, LinkedQueue<Key> q) {
        if (node == null) return;
        inorder(node.left, q);
        q.enqueue(node.key);

    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    BinaryTreeNode deleteMin(BinaryTreeNode x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * Hibbard Deletion:  We find the given Key in the tree with root x.
     * If x has 0 children, delete x.
     * If x has 1 child, replace x with its child.
     * If x has >=2 children, replace x with the min element from x's right subtree.
     * Note that Hibbard Deletion is unsatisfactory because its asymmetry leads to unbalanced trees
     * with depth sqrt(n) rather than log_2 (n).
     * @param x The root node of the tree from which to delete
     * @param key The key to delete
     * @return
     */
    BinaryTreeNode delete(BinaryTreeNode x, Key key) {
        if (x == null) return null;
        int comparisonResult = key.compareTo(x.key);
        if (comparisonResult < 0) x.left = delete (x.left, key);
        else if (comparisonResult > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            BinaryTreeNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    BinaryTreeNode min(BinaryTreeNode x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
