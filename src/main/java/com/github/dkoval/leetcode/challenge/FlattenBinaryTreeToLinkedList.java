package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
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
public interface FlattenBinaryTreeToLinkedList {

    void flatten(TreeNode root);

    // O(N) time | O(N) space
    class FlattenBinaryTreeToLinkedListRev1 implements FlattenBinaryTreeToLinkedList {

        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;

            flatten(left);
            flatten(right);

            root.left = null;
            root.right = left;
            findRightMost(root).right = right;
        }

        private TreeNode findRightMost(TreeNode root) {
            TreeNode curr = root;
            while (curr != null && curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }
    }

    // O(N) time | O(N) space
    class FlattenBinaryTreeToLinkedListRev2 implements FlattenBinaryTreeToLinkedList {

        // Resource: https://www.youtube.com/watch?v=rKnD7rLT0lI
        @Override
        public void flatten(TreeNode root) {
            doFlatten(root);
        }

        // Flattens the `root` tree into a list and returns its tail
        private TreeNode doFlatten(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode leftTail = doFlatten(root.left);
            TreeNode rightTail = doFlatten(root.right);

            // connect flattened subtrees
            if (leftTail != null) {
                leftTail.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            // return the tail of the flattened list
            if (leftTail == null && rightTail == null) {
                return root;
            }
            return (rightTail != null) ? rightTail : leftTail;
        }
    }
}
