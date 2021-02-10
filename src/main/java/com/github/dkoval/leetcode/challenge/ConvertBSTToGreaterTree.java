package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/">Convert BST to Greater Tree</a>
 * <p>
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <ul>
 *  <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 *  <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 *  <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 */
public abstract class ConvertBSTToGreaterTree {

    public abstract TreeNode convertBST(TreeNode root);

    // O(N) time | O(H) space, where H - height of a BST
    public static class ConvertBSTToGreaterTreeUsingRecursiveReversedInorderTraversal extends ConvertBSTToGreaterTree {
        private int sum = 0;

        @Override
        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }

    // O(N) time | O(H) space, where H - height of a BST
    public static class ConvertBSTToGreaterTreeUsingStackForReversedInorderTraversal extends ConvertBSTToGreaterTree {

        @Override
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode curr = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.right;
                }
                curr = stack.pop();
                sum += curr.val;
                curr.val = sum;
                curr = curr.left;
            }
            return root;
        }
    }
}
