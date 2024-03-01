package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">Find Bottom Left Tree Value</a>
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>-2^31 <= Node.val <= 2^31 - 1</li>
 * </ul>
 */
public interface FindBottomLeftTreeValue {

    int findBottomLeftValue(TreeNode root);

    class FindBottomLeftTreeValueRev1 implements FindBottomLeftTreeValue {

        @Override
        public int findBottomLeftValue(TreeNode root) {
            int depth = depth(root);
            // level order traversal
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (depth-- > 1) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }
            return q.poll().val;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    class FindBottomLeftTreeValueRev2 implements FindBottomLeftTreeValue {

        @Override
        public int findBottomLeftValue(TreeNode root) {
            TreeNode leftMost = null;
            Deque<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                leftMost = q.peekFirst();
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }
            return leftMost.val;
        }
    }

    class FindBottomLeftTreeValueRev3 implements FindBottomLeftTreeValue {

        @Override
        public int findBottomLeftValue(TreeNode root) {
            TreeNodeInfo ans = new TreeNodeInfo(root, 0);
            traverse(root, 0, ans);
            return ans.node.val;
        }

        private void traverse(TreeNode node, int level, TreeNodeInfo ans) {
            if (node == null) {
                return;
            }

            traverse(node.left, level + 1, ans);
            traverse(node.right, level + 1, ans);

            if (level > ans.level) {
                ans.node = node;
                ans.level = level;
            }
        }

        private static class TreeNodeInfo {
            TreeNode node;
            int level;

            TreeNodeInfo(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
    }
}
