package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;
import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/">Linked List in Binary Tree</a>
 * <p>
 * Given a binary tree root and a linked list with head as the first node.
 * <p>
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected
 * in the binary tree otherwise return False.
 * <p>
 * In this context downward path means a path that starts at some node and goes downwards.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree will be in the range [1, 2500].</li>
 *  <li>The number of nodes in the list will be in the range [1, 100].</li>
 *  <li>1 <= Node.val <= 100 for each node in the linked list and binary tree.</li>
 * </ul>
 */
public interface LinkedListInBinaryTree {

    boolean isSubPath(ListNode head, TreeNode root);

    class LinkedListInBinaryTreeRev1 implements LinkedListInBinaryTree {

        @Override
        public boolean isSubPath(ListNode head, TreeNode root) {
            return traverse(root, head);
        }

        // check if the given binary tree matches the entire linked list
        private boolean matches(TreeNode root, ListNode head) {
            if (head == null) {
                return true;
            }

            if (root == null || root.val != head.val) {
                return false;
            }

            return matches(root.left, head.next) || matches(root.right, head.next);
        }

        // try every node of a binary tree to find a match
        private boolean traverse(TreeNode root, ListNode head) {
            if (root == null) {
                return false;
            }

            if (matches(root, head)) {
                return true;
            }

            return traverse(root.left, head) || traverse(root.right, head);
        }
    }
}
