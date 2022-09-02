package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Average of Levels in Binary Tree</a>
 * <p>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10^-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>-2^31 <= Node.val <= 2^31 - 1</li>
 * </ul>
 */
public interface AverageOfLevelsInBinaryTree {

    List<Double> averageOfLevels(TreeNode root);

    class AverageOfLevelsInBinaryTreeRev1 implements AverageOfLevelsInBinaryTree {

        // O(N) time | O(2^H) space, where
        // N - total number of nodes in the tree
        // H - height of the tree
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int n = q.size();
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    TreeNode curr = q.poll();
                    sum += curr.val;

                    if (curr.left != null) {
                        q.offer(curr.left);
                    }

                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                ans.add((double) sum / n);
            }
            return ans;
        }
    }
}
