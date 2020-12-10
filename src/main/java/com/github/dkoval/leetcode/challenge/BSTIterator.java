package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * <ul>
 * <li>BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor.
 * The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * </li>
 * <li>boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
 * otherwise returns false.</li>
 * <li>int next() Moves the pointer to the right, then returns the number at the pointer.</li>
 * <ul>
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return t
 * he smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number
 * in the in-order traversal when next() is called.
 * <p>
 * Follow up:
 * <p>
 * Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
 */
public abstract class BSTIterator {

    public abstract int next();

    public abstract boolean hasNext();

    public static class BSTIteratorNaive extends BSTIterator {
        private final Iterator<Integer> iter;

        // O(N) time | O(N) space
        public BSTIteratorNaive(TreeNode root) {
            List<Integer> inorder = new LinkedList<>();
            doInorder(root, inorder);
            this.iter = inorder.iterator();
        }

        private void doInorder(TreeNode root, List<Integer> inorder) {
            if (root == null) {
                return;
            }
            doInorder(root.left, inorder);
            inorder.add(root.val);
            doInorder(root.right, inorder);
        }

        @Override
        public int next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }
    }

    public static class BSTIteratorUsingStack extends BSTIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        // next() and hasNext() run in average in O(1) time and use O(h) space, where h is the height of the tree
        public BSTIteratorUsingStack(TreeNode root) {
            inorderLeft(root);
        }

        private void inorderLeft(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        @Override
        public int next() {
            TreeNode top = stack.pop();
            if (top.right != null) {
                inorderLeft(top.right);
            }
            return top.val;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
