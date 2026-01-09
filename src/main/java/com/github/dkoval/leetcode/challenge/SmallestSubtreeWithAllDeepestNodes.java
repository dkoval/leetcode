package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/">Smallest Subtree with all the Deepest Nodes</a>
 * <p>
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 * <p>
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 * <p>
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 * <p>
 * The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree will be in the range [1, 500].</li>
 *  <li>0 <= Node.val <= 500</li>
 *  <li>The values of the nodes in the tree are unique.</li>
 * </ul>
 */
public interface SmallestSubtreeWithAllDeepestNodes {

    TreeNode subtreeWithAllDeepest(TreeNode root);

    // O(N) time | O(N) space
    class SmallestSubtreeWithAllDeepestNodesRev1 implements SmallestSubtreeWithAllDeepestNodes {

        @Override
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null) {
                return null;
            }

            final var leftHeight = height(root.left);
            final var rightHeight = height(root.right);

            if (leftHeight > rightHeight) {
                return subtreeWithAllDeepest(root.left);
            } else if (rightHeight > leftHeight) {
                return subtreeWithAllDeepest(root.right);
            } else {
                return root;
            }
        }

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
