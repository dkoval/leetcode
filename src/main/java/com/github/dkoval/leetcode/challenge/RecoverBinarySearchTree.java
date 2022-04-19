package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/">Recover Binary Search Tree</a>
 * <p>
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 * <p>
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [2, 1000]</li>
 *  -231 <= Node.val <= 231 - 1
 * </ul>
 */
public class RecoverBinarySearchTree {

    private static class TreeInfo {
        TreeNode prev;
        TreeNode first;
        TreeNode second;
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        // Fact: inorder traversal of a BST visits nodes in sorted asc order
        TreeInfo info = new TreeInfo();
        inorder(root, info);
        if (info.first != null && info.second != null) {
            int tmp = info.first.val;
            info.first.val = info.second.val;
            info.second.val = tmp;
        }
    }

    private void inorder(TreeNode root, TreeInfo info) {
        if (root == null) {
            return;
        }

        // visit left subtree
        inorder(root.left, info);

        if (info.prev != null && info.prev.val > root.val) {
            if (info.first == null) {
                info.first = info.prev;
                info.second = root;
            } else {
                // TreeNodes to swap have been found, no need to traverse the tree further
                info.second = root;
                return;
            }
        }
        info.prev = root;

        // visit right subtree
        inorder(root.right, info);
    }
}
