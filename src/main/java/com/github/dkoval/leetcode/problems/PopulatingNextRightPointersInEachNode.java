package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node</a>
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Follow-up:
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNode {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // O(N) time | O(1) space
    public Node connect(Node root) {
        // head of the singly linked list forming the current level
        Node levelHead = root;
        while (levelHead != null) {
            Node curr = levelHead;
            Node prev = null;
            // connect nodes on the next level;
            // curr.left == null means that the current level if the last one, thus no further work is required
            while (curr != null && curr.left != null) {
                curr.left.next = curr.right;
                if (prev != null) {
                    prev.right.next = curr.left;
                }
                prev = curr;
                curr = curr.next;
            }
            // proceed to the next level
            levelHead = levelHead.left;
        }
        return root;
    }
}
