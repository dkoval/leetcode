package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">Binary Search Tree to Greater Sum Tree</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus the sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 100]</li>
 *  <li>0 <= Node.val <= 100</li>
 *  <li>All the values in the tree are unique</li>
 * </ul>
 */
public interface BinarySearchTreeToGreaterSumTree {

    TreeNode bstToGst(TreeNode root);

    // O(N) time | O(N) space
    class BinarySearchTreeToGreaterSumTreeRev1 implements BinarySearchTreeToGreaterSumTree {

        @Override
        public TreeNode bstToGst(TreeNode root) {
            // inorder traversal of a BST organizes nodes in sorted order
            List<TreeNode> nodes = new ArrayList<>();
            int sum = traverse(root, nodes);

            // prefixSum[i] = sum(nums[0 : i])
            // prefixSum[i] = sum(nums[0 : n - 1]) - prefixSum[i - 1]
            int prefixSum = 0;
            for (TreeNode node : nodes) {
                int x = node.val;
                node.val = sum - prefixSum;
                prefixSum += x;
            }
            return root;
        }

        private int traverse(TreeNode node, List<TreeNode> nodes) {
            if (node == null) {
                return 0;
            }

            int sum = 0;

            // inorder traversal
            sum += traverse(node.left, nodes);
            sum += node.val;
            nodes.add(node);
            sum += traverse(node.right, nodes);
            return sum;
        }
    }
}
