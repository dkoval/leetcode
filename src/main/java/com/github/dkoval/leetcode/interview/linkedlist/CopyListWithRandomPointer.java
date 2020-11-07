package com.github.dkoval.leetcode.interview.linkedlist;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/60/linked-list-5/3066/">Copy List with Random Pointer</a>
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // tweak the original linked list by interweaving the nodes of the old and copied list:
        // A --> A' --> B --> B' --> C --> C' --> D --> D'
        Node oldCurr = head;
        while (oldCurr != null) {
            Node oldNext = oldCurr.next;
            Node copyNode = new Node(oldCurr.val);
            oldCurr.next = copyNode;
            copyNode.next = oldNext;
            oldCurr = oldNext;
        }
        // resolve random pointers
        oldCurr = head;
        while (oldCurr != null && oldCurr.next != null) {
            Node oldNext = oldCurr.next.next;
            if (oldCurr.random != null) {
                oldCurr.next.random = oldCurr.random.next;
            }
            oldCurr = oldNext;
        }
        // collect copied nodes as well as restore the original linked list
        oldCurr = head;
        Node copyDummyHead = new Node(42), copyCurr = copyDummyHead;
        while (oldCurr != null && oldCurr.next != null) {
            copyCurr.next = oldCurr.next;
            copyCurr = copyCurr.next;
            oldCurr.next = oldCurr.next.next;
            oldCurr = oldCurr.next;
        }
        return copyDummyHead.next;
    }
}
