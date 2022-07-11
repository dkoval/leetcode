package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 100]</li>
 *  <li>-100 <= Node.val <= 100</li>
 * </ul>
 */
public interface BinaryTreeRightSideView {

    List<Integer> rightSideView(TreeNode root);

    class BinaryTreeRightSideViewLevelOrderTraversalRev1 implements BinaryTreeRightSideView {

        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    if (size == 0) {
                        // last element of i-th level
                        result.add(node.val);
                    }
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            return result;
        }
    }

    class BinaryTreeRightSideViewLevelOrderTraversalRev2 implements BinaryTreeRightSideView {

        @Override
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                result.add(q.peek().val);
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                }
            }
            return result;
        }
    }

    class BinaryTreeRightSideViewPreorderTraversal implements BinaryTreeRightSideView {

        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, 0, result);
            return result;
        }

        private void preorder(TreeNode root, int depth, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(root.val);
            }
            preorder(root.right, depth + 1, result);
            preorder(root.left, depth + 1, result);
        }
    }
}
