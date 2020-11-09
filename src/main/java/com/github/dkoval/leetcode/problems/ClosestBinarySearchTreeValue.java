package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/closest-binary-search-tree-value/">Closest Binary Search Tree Value</a>
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 */
public abstract class ClosestBinarySearchTreeValue {

    public abstract int closestValue(TreeNode root, double target);

    public static class ClosestBinarySearchTreeValueIter extends ClosestBinarySearchTreeValue {

        // Average: O(logN) time | O(1) space
        // Worst: O(N) time | O(1) space
        @Override
        public int closestValue(TreeNode root, double target) {
            int closestValue = root.val;
            TreeNode curr = root;
            while (curr != null) {
                if (Math.abs(curr.val - target) < Math.abs(closestValue - target)) {
                    closestValue = curr.val;
                }
                if (target < curr.val) {
                    curr = curr.left;
                } else if (target > curr.val) {
                    curr = curr.right;
                } else {
                    break;
                }
            }
            return closestValue;
        }
    }

    public static class ClosestBinarySearchTreeValueRecursive extends ClosestBinarySearchTreeValue {

        // Average: O(logN) time | O(logN) space
        // Worst: O(N) time | O(N) space
        @Override
        public int closestValue(TreeNode root, double target) {
            return doClosestValue(root, target, root.val);
        }

        private int doClosestValue(TreeNode root, double target, int closestValueSoFar) {
            if (Math.abs(root.val - target) < Math.abs(closestValueSoFar - target)) {
                closestValueSoFar = root.val;
            }
            if (target < root.val && root.left != null) {
                return doClosestValue(root.left, target, closestValueSoFar);
            } else if (target > root.val && root.right != null) {
                return doClosestValue(root.right, target, closestValueSoFar);
            } else {
                return closestValueSoFar;
            }
        }
    }
}
