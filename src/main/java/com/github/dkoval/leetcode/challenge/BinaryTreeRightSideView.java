package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/">Binary Tree Right Side View</a>
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 */
public abstract class BinaryTreeRightSideView {

    public abstract List<Integer> rightSideView(TreeNode root);

    public static class BinaryTreeRightSideViewLevelOrderTraversal extends BinaryTreeRightSideView {

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

    public static class BinaryTreeRightSideViewPreorderTraversal extends BinaryTreeRightSideView {

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
