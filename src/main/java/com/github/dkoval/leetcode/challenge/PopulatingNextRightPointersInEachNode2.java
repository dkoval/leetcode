package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

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
public interface PopulatingNextRightPointersInEachNode2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node connect(Node root);

    // O(N) time since we process each node exactly once | O(N) space
    class PopulatingNextRightPointersInEachNode2UsingDeque implements PopulatingNextRightPointersInEachNode2 {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                Node prev = null;
                while (size-- > 0) {
                    Node curr = q.poll();
                    if (prev != null) {
                        prev.next = curr;
                    }
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                    prev = curr;
                }
            }
            return root;
        }
    }

    // O(N) time since we process each node exactly once | O(H) space
    class PopulatingNextRightPointersInEachNode2UsingPrevPointerRev1 implements PopulatingNextRightPointersInEachNode2 {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node curr = root;
            // process the tree in a BFS manner, i.e. level by level
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

    // O(N) time since we process each node exactly once | O(1) space
    class PopulatingNextRightPointersInEachNode2UsingPrevPointerRev2 implements PopulatingNextRightPointersInEachNode2 {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            // process the tree in a BFS manner, i.e. level by level
            Node head = root;
            while (head != null) {
                Node curr = head;
                Node prev = null;
                Node newHead = null; // head of the list at the next level

                // connect nodes at the next level
                while (curr != null) {
                    if (curr.left != null) {
                        if (prev != null) {
                            prev.next = curr.left;
                            prev = prev.next;
                        } else {
                            prev = curr.left;
                            newHead = curr.left;
                        }
                    }

                    if (curr.right != null) {
                        if (prev != null) {
                            prev.next = curr.right;
                            prev = prev.next;
                        } else {
                            prev = curr.right;
                            newHead = curr.right;
                        }
                    }
                    curr = curr.next;
                }
                head = newHead;
            }
            return root;
        }
    }
}
