package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/">Count Nodes Equal to Average of Subtree</a>
 * <p>
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
 * <p>
 * Note:
 * <ul>
 *  <li>The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.</li>
 *  <li>A subtree of root is a tree consisting of root and all of its descendants.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 1000].</li>
 *  <li>0 <= Node.val <= 1000</li>
 * </ul>
 */
public interface CountNodesEqualToAverageOfSubtree {

    int averageOfSubtree(TreeNode root);

    // O(N) time | O(H) space
    class CountNodesEqualToAverageOfSubtreeRev1 implements CountNodesEqualToAverageOfSubtree {

        @Override
        public int averageOfSubtree(TreeNode root) {
            final var ans = new int[]{0};
            traverse(root, ans);
            return ans[0];
        }

        private TreeInfo traverse(TreeNode node, int[] ans) {
            if (node == null) {
                return new TreeInfo(0, 0);
            }

            // post-order traversal
            final var left = traverse(node.left, ans);
            final var right = traverse(node.right, ans);

            final var sum = left.sum + right.sum + node.val;
            final var count = left.count + right.count + 1;
            if (sum / count == node.val) {
                ans[0]++;
            }
            return new TreeInfo(sum, count);
        }

        private record TreeInfo(
                int sum,
                int count
        ) {
        }
    }
}
