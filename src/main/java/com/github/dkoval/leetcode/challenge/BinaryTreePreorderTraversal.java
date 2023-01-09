package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal</a>
 * <p>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 100].</li>
 *  <li>-100 <= Node.val <= 100</li>
 * </ul>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public interface BinaryTreePreorderTraversal {

    List<Integer> preorderTraversal(TreeNode root);

    class BinaryTreePreorderTraversalRecursive implements BinaryTreePreorderTraversal {

        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            preorder(root, ans);
            return ans;
        }

        private void preorder(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            ans.add(root.val);
            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }

    class BinaryTreePreorderTraversalIterative implements BinaryTreePreorderTraversal {

        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                ans.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
            return ans;
        }
    }
}
