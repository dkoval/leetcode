package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Maximum Width of Binary Tree</a>
 * <p>
 * Given the root of a binary tree, return the maximum width of the given tree.
 * <p>
 * The maximum width of a tree is the maximum width among all levels.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level
 * are also counted into the length calculation.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 3000].</li>
 *  <li>-100 <= Node.val <= 100</li>
 * </ul>
 */
public interface MaximumWidthOfBinaryTree {

    int widthOfBinaryTree(TreeNode root);

    // O(N) time | O(N) space
    class MaximumWidthOfBinaryTreeRev1 implements MaximumWidthOfBinaryTree {

        @Override
        public int widthOfBinaryTree(TreeNode root) {
            // idea: enumerate nodes + BFS
            int best = 0;

            // BFS
            Deque<Node> q = new ArrayDeque<>();
            q.offer(new Node(root, 1));
            while (!q.isEmpty()) {
                // take the number of nodes at the current level
                Node left = q.peekFirst();
                Node right = q.peekLast();
                best = Math.max(best, right.seqNo - left.seqNo + 1);

                // process all nodes at the current level
                int size = q.size();
                while (size-- > 0) {
                    Node curr = q.poll();

                    if (curr.node.left != null) {
                        q.offerLast(new Node(curr.node.left, 2 * curr.seqNo));
                    }

                    if (curr.node.right != null) {
                        q.offerLast(new Node(curr.node.right, 2 * curr.seqNo + 1));
                    }
                }
            }
            return best;
        }

        private static class Node {
            final TreeNode node;
            final int seqNo;

            Node(TreeNode node, int seqNo) {
                this.node = node;
                this.seqNo = seqNo;
            }
        }
    }
}
