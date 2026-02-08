package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="Balanced Binary Tree">https://leetcode.com/problems/balanced-binary-tree/</a>
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 5000]</li>
 *  <li>-10^4 <= Node.val <= 10^4</li>
 * </ul>
 */
public interface BalancedBinaryTree {

    boolean isBalanced(TreeNode root);

    class BalancedBinaryTreeRev1 implements BalancedBinaryTree {

        // Resource: https://leetcode.com/problems/balanced-binary-tree/solution/
        // Time complexity: O(N^2).
        // Space complexity: O(N). The recursion stack may contain all nodes if the tree is skewed.
        @Override
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            if (root == null) {
                return -1;
            }

            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    class BalancedBinaryTreeRecursive implements BalancedBinaryTree {

        // Time complexity: O(N). For every subtree, we compute its height in constant time as well as compare the height of its children.
        // Space complexity: O(N). The recursion stack may go up to O(N) if the tree is unbalanced.
        @Override
        public boolean isBalanced(TreeNode root) {
            return checkIfBalancedAndComputeHeight(root).isBalanced;
        }

        private record Answer(boolean isBalanced, int height) {

            static final Answer NOT_BALANCED = new Answer(false, -1);
        }

        private Answer checkIfBalancedAndComputeHeight(TreeNode root) {
            if (root == null) {
                return new Answer(true, -1);
            }

            Answer left = checkIfBalancedAndComputeHeight(root.left);
            if (!left.isBalanced) {
                return Answer.NOT_BALANCED;
            }

            Answer right = checkIfBalancedAndComputeHeight(root.right);
            if (!right.isBalanced) {
                return Answer.NOT_BALANCED;
            }

            if (Math.abs(left.height - right.height) > 1) {
                return Answer.NOT_BALANCED;
            }

            return new Answer(true, 1 + Math.max(left.height, right.height));
        }
    }
}
