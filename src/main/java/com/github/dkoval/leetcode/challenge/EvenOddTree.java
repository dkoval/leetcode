package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/even-odd-tree/">Even Odd Tree</a>
 * <p>
 * A binary tree is named Even-Odd if it meets the following conditions:
 * <ul>
 *  <li>The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.</li>
 *  <li>For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).</li>
 *  <li>For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).</li>
 * </ul>
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^5]</li>
 *  <li>1 <= Node.val <= 10^6</li>
 * </ul>
 */
public interface EvenOddTree {

    boolean isEvenOddTree(TreeNode root);

    class EvenOddTreeRev1 implements EvenOddTree {

        @Override
        public boolean isEvenOddTree(TreeNode root) {
            // level-order traversal
            boolean even = true;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                TreeNode prev = null;
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (!good(even, prev, curr)) {
                        return false;
                    }
                    prev = curr;

                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                even = !even;
            }
            return true;
        }

        private boolean good(boolean even, TreeNode prev, TreeNode curr) {
            return even
                    ? curr.val % 2 != 0 && (prev == null || curr.val > prev.val)
                    : curr.val % 2 != 1 && (prev == null || curr.val < prev.val);
        }
    }
}
