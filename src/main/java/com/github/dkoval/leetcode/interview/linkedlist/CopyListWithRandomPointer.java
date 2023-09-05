package com.github.dkoval.leetcode.interview.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers
 * in the original list and copied list represent the same list state. None of the pointers in the new list should point
 * to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
 * two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <ul>
 *  <li>val: an integer representing Node.val</li>
 *  <li>random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.</li>
 * </ul>
 * Your code will only be given the head of the original linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= n <= 1000</li>
 *  <li>-10^4 <= Node.val <= 10^4</li>
 *  <li>Node.random is null or is pointing to some node in the linked list.</li>
 * </ul>
 */
public interface CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Node copyRandomList(Node head);

    // O(N) time | O(N) extra space
    class CopyListWithRandomPointerUsingExtraSpace implements CopyListWithRandomPointer {

        @Override
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Map<Node, Node> copied = new HashMap<>();

            // 1st pass - copy nodes
            Node dummy = new Node(42);
            Node lastCopy = dummy;
            Node currOld = head;
            while (currOld != null) {
                Node copy = new Node(currOld.val);
                copied.put(currOld, copy);
                lastCopy.next = copy;
                lastCopy = lastCopy.next;
                currOld = currOld.next;
            }

            // 2nd pass - resolve `random` pointers
            currOld = head;
            while (currOld != null) {
                if (currOld.random != null) {
                    Node copy = copied.get(currOld);
                    copy.random = copied.get(currOld.random);
                }
                currOld = currOld.next;
            }
            return dummy.next;
        }
    }

    // O(N) time | O(1) extra space
    class CopyListWithRandomPointerSpaceOptimized implements CopyListWithRandomPointer {

        @Override
        public Node copyRandomList(Node head) {
            // tweak the original linked list by interweaving the nodes of the old and copied list:
            // A --> A' --> B --> B' --> C --> C' --> D --> D'
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node copy = new Node(curr.val);
                curr.next = copy;
                copy.next = next;
                curr = next;
            }
            // resolve random pointers
            curr = head;
            while (curr != null && curr.next != null) {
                Node next = curr.next.next;
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = next;
            }
            // collect copied nodes while restoring the original list
            curr = head;
            Node dummy = new Node(42), copy = dummy;
            while (curr != null && curr.next != null) {
                copy.next = curr.next;
                copy = copy.next;
                curr.next = curr.next.next;
                curr = curr.next;
            }
            return dummy.next;
        }
    }
}
