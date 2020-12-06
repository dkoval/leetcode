package com.github.dkoval.leetcode.challenge;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3556/">Populating Next Right Pointers in Each Node II</a>
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Follow up:
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.</li>
 * </ul>
 */
public abstract class PopulatingNextRightPointersInEachNode2 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public abstract Node connect(Node root);

    // O(N) time since we process each node exactly once | O(N) space
    public static class PopulatingNextRightPointersInEachNode2UsingDeque extends PopulatingNextRightPointersInEachNode2 {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> q = new LinkedList<>();
            q.addLast(root);
            while (!q.isEmpty()) {
                int size = q.size();
                Node prev = null;
                while (size-- > 0) {
                    Node last = q.removeLast();
                    last.next = prev;
                    prev = last;
                    if (last.right != null) {
                        q.addFirst(last.right);
                    }
                    if (last.left != null) {
                        q.addFirst(last.left);
                    }
                }
            }
            return root;
        }
    }

    // O(N) time since we process each node exactly once | O(1) space
    public static class PopulatingNextRightPointersInEachNode2UsingPreviousNextPointers extends PopulatingNextRightPointersInEachNode2 {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node curr = root;
            // process the tree in a BFS manner, i.e level by level
            while (curr != null) {
                // while on level N, establish the next pointers on level (N + 1)
                Node dummy = new Node(42), prev = dummy;
                while (curr != null) {
                    if (curr.left != null) {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                    if (curr.right != null) {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                    curr = curr.next;
                }
                curr = dummy.next;
            }
            return root;
        }
    }
}
