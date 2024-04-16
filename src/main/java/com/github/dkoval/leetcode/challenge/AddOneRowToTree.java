package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/add-one-row-to-tree/">Add One Row to Tree</a>
 * <p>
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
 * <p>
 * Note that the root node is at depth 1.
 * <p>
 * The adding rule is:
 * <ul>
 *  <li>Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.</li>
 *  <li>cur's original left subtree should be the left subtree of the new left subtree root.</li>
 *  <li>cur's original right subtree should be the right subtree of the new right subtree root.</li>
 *  <li>If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4].</li>
 *  <li>The depth of the tree is in the range [1, 10^4].</li>
 *  <li>-100 <= Node.val <= 100</li>
 *  <li>-10^5 <= val <= 10^5</li>
 *  <li>1 <= depth <= the depth of tree + 1</li>
 * </ul>
 */
public interface AddOneRowToTree {

    TreeNode addOneRow(TreeNode root, int val, int depth);

    class AddOneRowToTreeRev1 implements AddOneRowToTree {

        @Override
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            }

            // ~BFS: generate (depth - 1) level
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            int currDepth = 1;
            while (currDepth < depth - 1) {
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
                currDepth++;
            }

            // process (depth - 1) level
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                curr.left = new TreeNode(val);
                curr.right = new TreeNode(val);
                curr.left.left = left;
                curr.right.right = right;
            }
            return root;
        }
    }

    class AddOneRowToTreeRev2 implements AddOneRowToTree {

        @Override
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            }

            dfs(null, root, false, depth - 1, val);
            return root;
        }

        private void dfs(TreeNode parent, TreeNode node, boolean leftChild, int depth, int val) {
            // base case
            if (depth == 0) {
                TreeNode newNode = new TreeNode(val);
                if (node == null) {
                    // append to the last level
                    if (leftChild) {
                        parent.left = newNode;
                    } else {
                        parent.right = newNode;
                    }
                } else {
                    // insert in the middle
                    if (leftChild) {
                        parent.left = newNode;
                        newNode.left = node;
                    } else {
                        parent.right = newNode;
                        newNode.right = node;
                    }
                }
                return;
            }

            if (node == null) {
                return;
            }

            dfs(node, node.left, true, depth - 1, val);
            dfs(node, node.right, false, depth - 1, val);
        }
    }
}
