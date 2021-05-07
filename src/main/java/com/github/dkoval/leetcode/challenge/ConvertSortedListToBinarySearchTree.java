package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;
import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3733/">Convert Sorted List to Binary Search Tree</a>
 * <p>
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 */
public class ConvertSortedListToBinarySearchTree {

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
