package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3514/">Recover Binary Search Tree</a>
 * <p>
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;
    private TreeNode first, second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // Fact: inorder traversal of a BST visits nodes in sorted asc order
        inorder(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
