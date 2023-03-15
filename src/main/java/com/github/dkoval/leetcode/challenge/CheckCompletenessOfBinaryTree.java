package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">Check Completeness of a Binary Tree</a>
 * <p>
 * Given the root of a binary tree, determine if it is a complete binary tree.
 * <p>
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 100].</li>
 *  <li>1 <= Node.val <= 1000</li>
 * </ul>
 */
public interface CheckCompletenessOfBinaryTree {

    boolean isCompleteTree(TreeNode root);

    // O(N) time | O(2^H) size
    class CheckCompletenessOfBinaryTreeRev1 implements CheckCompletenessOfBinaryTree {

        @Override
        public boolean isCompleteTree(TreeNode root) {
            // BFS
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            int level = 0;
            while (!q.isEmpty()) {
                // number of nodes in the current level
                int n = q.size();
                // determines a "gap" between subsequent nodes in the next level
                boolean gap = false;
                for (int i = 0; i < n; i++) {
                    TreeNode curr = q.poll();
                    if (curr.left != null) {
                        if (gap) {
                            return false;
                        }
                        q.offer(curr.left);
                    } else {
                        gap = true;
                    }

                    if (curr.right != null) {
                        if (gap) {
                            return false;
                        }
                        q.offer(curr.right);
                    } else {
                        gap = true;
                    }
                }

                // every level, except possibly the last, is completely filled
                if (!q.isEmpty() && n != (1 << level)) {
                    return false;
                }
                level++;
            }
            return true;
        }
    }
}
