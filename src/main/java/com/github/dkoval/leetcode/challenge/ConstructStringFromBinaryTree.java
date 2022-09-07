package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">Construct String from Binary Tree</a>
 * <p>
 * Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree
 * with the preorder traversal way, and return it.
 * <p>
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string
 * and the original binary tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>-1000 <= Node.val <= 1000</li>
 */
public interface ConstructStringFromBinaryTree {

    String tree2str(TreeNode root);

    // O(N) time | O(N) space
    class ConstructStringFromBinaryTreeRev1 implements ConstructStringFromBinaryTree {

        @Override
        public String tree2str(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);
            return sb.toString();
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }

            sb.append(root.val);

            // is root a leaf node?
            if (root.left == null && root.right == null) {
                return;
            }

            sb.append('(');
            preorder(root.left, sb);
            sb.append(')');

            // omit generating empty parenthesis if the right subtree doesn't exist
            if (root.right != null) {
                sb.append('(');
                preorder(root.right, sb);
                sb.append(')');
            }
        }
    }
}
