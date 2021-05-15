package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3742/">Flatten Binary Tree to Linked List</a>
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <ul>
 *  <li>
 *  The "linked list" should use the same TreeNode class where the right child pointer points to the next node
 *  in the list and the left child pointer is always null.
 *  </li>
 *  <li>The "linked list" should be in the same order as a pre-order traversal of the binary tree.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [0, 2000].</li>
 *  <li>-100 <= Node.val <= 100.</li>
 * </ul>
 * <p>
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class FlattenBinaryTreeToLinkedList {

    // O(N) time | O(N) space
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode rightMost = findRightMost(root);
        rightMost.right = right;
    }

    private TreeNode findRightMost(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
}
