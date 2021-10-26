package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public interface InvertBinaryTree {

    TreeNode invertTree(TreeNode root);

    // O(N) time | O(N) space since in the worst case, the queue will contain all nodes in one level of the binary tree.
    // N - the number of nodes in the tree
    class InvertBinaryTreeIterative implements InvertBinaryTree {

        @Override
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                // swap left and right children
                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
                // null nodes are not added to the queue
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            return root;
        }
    }
}
