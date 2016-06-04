package com.jaredjstewart.coursera.princeton.algorithms.week8;

public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> extends BinarySearchTree<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * A <code>RedBlackBinaryTreeNode</code> is a BinaryTreeNode along with a color (red or black).
     * Red nodes represent 3-nodes in the corresponding 2-3 Tree.
     * For more information, see  <a href="http://algs4.cs.princeton.edu/33balanced/">Balanced Search Trees</a>.
     **/
    private class RedBlackBinaryTreeNode extends BinaryTreeNode {
        /*
        This is RED if the incoming link to this node is RED.
         */
        boolean color;
        RedBlackBinaryTreeNode left,right;

        public RedBlackBinaryTreeNode(Key key, Value value) {
            super(key, value);
        }
    }

    private boolean isRed(RedBlackBinaryTreeNode x) {
        return x != null && x.color == RED;
    }

    /**
     * Make a right-leaning red link lean to the left
     * @param h The node with a right-leaning red link
     * @return The node to replace <code>node</code> after this transformation.
     */
    private RedBlackBinaryTreeNode rotateLeft(RedBlackBinaryTreeNode h) {
        assert (h != null) && isRed(h.right);
        RedBlackBinaryTreeNode redNode = h.right;
        h.right = redNode.left;
        redNode.left = h;
        redNode.color = h.color;
        h.color = RED;
        return redNode;
    }

    /**
     * Make a left-leaning red link lean to the right
     * @param h The node with a left-leaning red link
     * @return The node to replace <code>node</code> after this transformation.
     */
    private RedBlackBinaryTreeNode rotateRight (RedBlackBinaryTreeNode h) {
        assert (h != null) && isRed(h.left);
        RedBlackBinaryTreeNode redNode = h.left;
        h.left = redNode.right;
        redNode.right = h;
        redNode.color = h.color;
        h.color = RED;
        return redNode;
    }

    private void flipColors(RedBlackBinaryTreeNode h)
    {
        assert h!= null && !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }


}
