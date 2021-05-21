package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3749/">Binary Tree Level Order Traversal</a>
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public interface BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levelOrder(TreeNode root);

    class BinaryTreeLevelOrderTraversalIter implements BinaryTreeLevelOrderTraversal {

        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> currLevel = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    currLevel.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                result.add(currLevel);
            }
            return result;
        }
    }

    class BinaryTreeLevelOrderTraversalRecursive implements BinaryTreeLevelOrderTraversal {

        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            traverse(root, 0, result);
            return result;
        }

        private void traverse(TreeNode root, int level, List<List<Integer>> result) {
            if (root == null) {
                return;
            }

            if (result.size() == level) {
                result.add(new ArrayList<>());
            }

            List<Integer> currLevel = result.get(level);
            currLevel.add(root.val);

            traverse(root.left, level + 1, result);
            traverse(root.right, level + 1, result);
        }
    }
}
