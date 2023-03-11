package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;
import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary Search Tree</a>
 * <p>
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in head is in the range [0, 2 * 10^4].</li>
 *  <li>-10^5 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface ConvertSortedListToBinarySearchTree {

    TreeNode sortedListToBST(ListNode head);

    class ConvertSortedListToBinarySearchTreeRev1 implements ConvertSortedListToBinarySearchTree {

        public TreeNode sortedListToBST(ListNode head) {
            return createBST(head);
        }

        private int length(ListNode head) {
            int l = 0;
            ListNode curr = head;
            while (curr != null) {
                l++;
                curr = curr.next;
            }
            return l;
        }

        private TreeNode createBST(ListNode head) {
            int n = length(head);
            if (n == 0) {
                return null;
            }
            if (n == 1) {
                return new TreeNode(head.val);
            }

            ListNode prev = null, mid = head;
            for (int i = 0; i < n / 2; i++) {
                prev = mid;
                mid = mid.next;
            }

            if (prev != null) {
                prev.next = null; // hack
            }

            ListNode next = mid.next;
            mid.next = null; // yet another hack

            TreeNode root = new TreeNode(mid.val);
            root.left = createBST(head); // before `mid`
            root.right = createBST(next); // after `mid`
            return root;
        }
    }

    class ConvertSortedListToBinarySearchTreeRev2 implements ConvertSortedListToBinarySearchTree {

        @Override
        public TreeNode sortedListToBST(ListNode head) {
            // base case #1: empty list
            if (head == null) {
                return null;
            }

            // base case #2: single-node list
            if (head.next == null) {
                return new TreeNode(head.val);
            }

            // find the mid node
            ListNode prev = null;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // sublist before the mid node
            if (prev != null) {
                prev.next = null;
            }

            // sublist after the mid node
            ListNode head2 = slow.next;
            slow.next = null;

            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(head2);
            return root;
        }
    }
}
