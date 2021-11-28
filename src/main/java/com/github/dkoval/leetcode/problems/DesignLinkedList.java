package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/design-linked-list/">Design Linked List</a>
 * <p>
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <ul>
 *  <li>MyLinkedList() Initializes the MyLinkedList object.</li>
 *  <li>int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.</li>
 *  <li>void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.</li>
 *  <li>void addAtTail(int val) Append a node of value val as the last element of the linked list.</li>
 *  <li>void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.</li>
 *  <li>void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= index, val <= 1000</li>
 *  <li>Please do not use the built-in LinkedList library.</li>
 *  <li>At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.</li>
 * </ul>
 */
public abstract class DesignLinkedList {

    static class MyLinkedList {
        private Node head;
        private Node tail;
        private int size = 0;

        public MyLinkedList() {
            // noop
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNodeAtIndex(index).val;
        }

        private Node getNodeAtIndex(int index) {
            int i = 0;
            Node curr = head;
            while (i < index) {
                i++;
                curr = curr.next;
            }
            return curr;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (head != null) {
                node.next = head;
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (tail != null) {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            if (head == null) {
                head = node;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node curr = getNodeAtIndex(index);
                Node node = new Node(val);

                Node prev = curr.prev;
                prev.next = node;
                node.prev = prev;
                node.next = curr;
                curr.prev = node;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            if (size == 1) {
                head = null;
                tail = null;
            } else if (index == 0) {
                head = head.next;
                head.prev = null;
            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node curr = getNodeAtIndex(index);
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            size--;
        }

        private static final class Node {
            int val;
            Node prev;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }
    }
}
