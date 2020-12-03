package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/increasing-order-search-tree/">Increasing Order Search Tree</a>
 * <p>
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
 * the root of the tree, and every node has no left child and only one right child.
 */
public abstract class IncreasingOrderSearchTree {

    public abstract TreeNode increasingBST(TreeNode root);

    // O(N) time | O(N) size
    public static class IncreasingOrderSearchTreeUsingInorderTraversal extends IncreasingOrderSearchTree {

        @Override
        public TreeNode increasingBST(TreeNode root) {
            // Idea: inorder traversal of a BST will yield all the values in increasing order
            List<Integer> traversal = new ArrayList<>();
            inorder(root, traversal);
            TreeNode dummyRoot = new TreeNode(42), curr = dummyRoot;
            for (int val : traversal) {
                curr.right = new TreeNode(val);
                curr = curr.right;
            }
            return dummyRoot.right;
        }

        private void inorder(TreeNode root, List<Integer> traversal) {
            if (root == null) {
                return;
            }
            inorder(root.left, traversal);
            traversal.add(root.val);
            inorder(root.right, traversal);
        }
    }
}
