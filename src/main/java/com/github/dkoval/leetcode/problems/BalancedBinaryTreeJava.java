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
 */
public abstract class BalancedBinaryTreeJava {

    private BalancedBinaryTreeJava() { /* prevents instantiation from the outside */}

    public abstract boolean isBalanced(TreeNode root);

    public static class BalancedBinaryTreeNaiveJava extends BalancedBinaryTreeJava {

        // Resource: https://leetcode.com/problems/balanced-binary-tree/solution/
        // Time complexity: O(NlogN).
        // Space complexity: O(N). The recursion stack may contain all nodes if the tree is skewed.
        @Override
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (Math.abs(height(root.left) - height(root.right)) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            if (root == null) {
                return -1;
            }
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public static class BalancedBinaryTreeRecursiveJava extends BalancedBinaryTreeJava {

        // Time complexity: O(N). For every subtree, we compute its height in constant time as well as compare the height of its children.
        // Space complexity: O(N). The recursion stack may go up to O(N) if the tree is unbalanced.
        @Override
        public boolean isBalanced(TreeNode root) {
            return checkIfBalancedAndComputeHeight(root).isBalanced;
        }

        private static class Answer {
            static final Answer NOT_BALANCED = new Answer(false, -1);

            final boolean isBalanced;
            final int height;

            private Answer(boolean isBalanced, int height) {
                this.isBalanced = isBalanced;
                this.height = height;
            }
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
