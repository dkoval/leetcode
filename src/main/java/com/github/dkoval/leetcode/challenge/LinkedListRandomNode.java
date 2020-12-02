package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3552/">Linked List Random Node</a>
 * <p>
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * <p>
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 */
public abstract class LinkedListRandomNode {

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        // noop be default
    }

    /**
     * @return a random node's value.
     */
    public abstract int getRandom();

    // O(N) time | O(N) space
    public static class LinkedListRandomNodeUsingExtraSpace extends LinkedListRandomNode {
        private final List<Integer> elements = new ArrayList<>();
        private final Random random = new Random();

        public LinkedListRandomNodeUsingExtraSpace(ListNode head) {
            super(head);
            while (head != null) {
                elements.add(head.val);
                head = head.next;
            }
        }

        @Override
        public int getRandom() {
            int idx = random.nextInt(elements.size());
            return elements.get(idx);
        }
    }

    // Reservoir sampling is an randomized algorithm that is used to select K out of N samples, where
    // N is usually a very large or unknown number.
    public static class LinkedListRandomNodeUsingReservoirSampling extends LinkedListRandomNode {
        private final ListNode head;

        public LinkedListRandomNodeUsingReservoirSampling(ListNode head) {
            super(head);
            this.head = head;
        }

        @Override
        public int getRandom() {
            int i = 1, random = -1;
            ListNode curr = head;
            while (curr != null) {
                if (Math.random() < 1.0 / i) {
                    random = curr.val;
                }
                i++;
                curr = curr.next;
            }
            return random;
        }
    }
}
