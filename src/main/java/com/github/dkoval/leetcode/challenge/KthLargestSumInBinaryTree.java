package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/">Kth Largest Sum in a Binary Tree</a>
 * <p>
 * You are given the root of a binary tree and a positive integer k.
 * <p>
 * The level sum in the tree is the sum of the values of the nodes that are on the same level.
 * <p>
 * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
 * <p>
 * Note that two nodes are on the same level if they have the same distance from the root.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is n.</li>
 *  <li>2 <= n <= 105</li>
 *  <li>1 <= Node.val <= 106</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface KthLargestSumInBinaryTree {

    long kthLargestLevelSum(TreeNode root, int k);

    class KthLargestSumInBinaryTreeRev1 implements KthLargestSumInBinaryTree {

        @Override
        public long kthLargestLevelSum(TreeNode root, int k) {
            Queue<Long> minHeap = new PriorityQueue<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                long sum = 0;
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    sum += curr.val;
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                minHeap.offer(sum);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            return minHeap.size() < k ? -1 : minHeap.peek();
        }
    }
}
