package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">Find Largest Value in Each Tree Row</a>
 * <p>
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree will be in the range [0, 10^4].</li>
 *  <li>-2^31 <= Node.val <= 2^31 - 1</li>
 * </ul>
 */
public interface FindLargestValueInEachTreeRow {

    List<Integer> largestValues(TreeNode root);

    class FindLargestValueInEachTreeRowRev1 implements FindLargestValueInEachTreeRow {

        @Override
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            // Idea: level order traversal
            List<Integer> ans = new ArrayList<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                // process all nodes at the current level
                int largest = Integer.MIN_VALUE;
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    largest = Math.max(largest, curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                ans.add(largest);
            }

            return ans;
        }
    }
}
