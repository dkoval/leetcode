package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves.
 * <p>
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 1000]</li>
 *  <li>-1000 <= Node.val <= 1000</li>
 * </ul>
 */
public interface SumOfLeftLeaves {

    int sumOfLeftLeaves(TreeNode root);

    class SumOfLeftLeavesBFS implements SumOfLeftLeaves {

        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;

            // BFS
            Queue<TreeNodeInfo> q = new ArrayDeque<>();
            q.offer(new TreeNodeInfo(root, false));
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNodeInfo curr = q.poll();

                    // is the current node a leaf?
                    if (curr.node.left == null && curr.node.right == null) {
                        // is the current node a left leaf?
                        if (curr.isLeftChild) {
                            sum += curr.node.val;
                        }
                        continue;
                    }

                    if (curr.node.left != null) {
                        q.offer(new TreeNodeInfo(curr.node.left, true));
                    }

                    if (curr.node.right != null) {
                        q.offer(new TreeNodeInfo(curr.node.right, false));
                    }
                }
            }
            return sum;
        }

        private static class TreeNodeInfo {
            final TreeNode node;
            final boolean isLeftChild;

            TreeNodeInfo(TreeNode node, boolean isLeftChild) {
                this.node = node;
                this.isLeftChild = isLeftChild;
            }
        }
    }
}
