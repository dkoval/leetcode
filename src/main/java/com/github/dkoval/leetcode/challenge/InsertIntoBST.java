package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="Insert into a Binary Search Tree">https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/</a>
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 * You can return any of them.
 */
public abstract class InsertIntoBST {

    public abstract TreeNode insertIntoBST(TreeNode root, int val);

    public static class InsertIntoBSTRecursive extends InsertIntoBST {

        @Override
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
