package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">Maximum Difference Between Node and Ancestor</a>
 * <p>
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * <p>
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 5000]</li>
 *  <li>0 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface MaximumDifferenceBetweenNodeAndAncestor {

    int maxAncestorDiff(TreeNode root);

    // O(N) time | O(N) space
    class MaximumDifferenceBetweenNodeAndAncestorPostOrderTraversal implements MaximumDifferenceBetweenNodeAndAncestor {

        private static class MinMax {
            final int min;
            final int max;

            MinMax(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }

        private static class TreeInfo {
            final int maxDiff;
            final MinMax bounds;

            TreeInfo(int maxDiff, MinMax bounds) {
                this.maxDiff = maxDiff;
                this.bounds = bounds;
            }
        }

        @Override
        public int maxAncestorDiff(TreeNode root) {
            return getMaxDiff(root).maxDiff;
        }

        private TreeInfo getMaxDiff(TreeNode node) {
            if (node == null) {
                return new TreeInfo(-1, new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE));
            }

            TreeInfo left = getMaxDiff(node.left);
            TreeInfo right = getMaxDiff(node.right);

            int min = Math.min(node.val, Math.min(left.bounds.min, right.bounds.min));
            int max = Math.max(node.val, Math.max(left.bounds.max, right.bounds.max));

            int maxDiff = Math.max(left.maxDiff, right.maxDiff);
            maxDiff = Math.max(maxDiff, max - node.val);
            maxDiff = Math.max(maxDiff, node.val - min);
            return new TreeInfo(maxDiff, new MinMax(min, max));
        }
    }

    // O(N) time | O(N) space
    class MaximumDifferenceBetweenNodeAndAncestorMaxMinusMin implements MaximumDifferenceBetweenNodeAndAncestor {

        @Override
        public int maxAncestorDiff(TreeNode root) {
            return getMaxDiff(root, root.val, root.val);
        }

        private int getMaxDiff(TreeNode node, int currMin, int currMax) {
            // return the maximum difference between max and min values of all root-to-leaf paths
            if (node == null) {
                return currMax - currMin;
            }

            currMin = Math.min(currMin, node.val);
            currMax = Math.max(currMax, node.val);

            int leftDiff = getMaxDiff(node.left, currMin, currMax);
            int rightDiff = getMaxDiff(node.right, currMin, currMax);
            return Math.max(leftDiff, rightDiff);
        }
    }
}
