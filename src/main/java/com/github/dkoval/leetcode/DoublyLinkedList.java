package com.github.dkoval.leetcode;

/**
 * {@code DoublyLinkedList} class has a {@code head} and a {@code tail}, both of which point to either a
 * {@link DoublyLinkedList.Node} or {@code null}. The class supports:
 * <ul>
 *     <li>Setting the head and tail of the linked list.</li>
 *     <li>Inserting nodes before and other nodes as well as at given positions (the position of the head node is 1).</li>
 *     <li>Removing given nodes and removing nodes with given values.</li>
 *     <li>Searching for nodes with given values.</li>
 * </ul>
 * Note that {@link #setHead(Node) setHead}, {@link #setTail(Node) setTail},
 * {@link #insertBefore(Node, Node) insertBefore}, {@link #insertAfter(Node, Node) insertAfter},
 * {@link #insertAtPosition(int, Node) insertAtPosition} and {@link #remove(Node) remove} methods all take in
 * actual {@code Node}s as input parameters. The input nodes can be either stand-alone nodes or nodes that are already
 * in the linked list. If they are nodes that are already in the linked list, the methods will effectively be moving
 * the nodes within the linked list.
 */
public class DoublyLinkedList {
    public Node head;
    public Node tail;

    /**
     * {@code Node} has an integer {@code value} as well as a {@code prev} and a {@code next} node, both of which
     * can point to another node or null.
     */
    public static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        if (node != head) {
            insertBefore(head, node);
        }
    }

    public void setTail(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }

        if (node != tail) {
            insertAfter(tail, node);
        }
    }

    public void insertBefore(Node before, Node node) {
        removeIfExists(node);

        Node prev = before.prev;
        if (prev != null) {
            prev.next = node;
            node.prev = prev;
        } else {
            head = node;
            node.prev = null;
        }

        node.next = before;
        before.prev = node;
    }

    public void insertAfter(Node after, Node node) {
        removeIfExists(node);

        Node next = after.next;
        if (next != null) {
            next.prev = node;
            node.next = next;
        } else {
            tail = node;
            node.next = null;
        }

        after.next = node;
        node.prev = after;
    }

    public void insertAtPosition(int position, Node node) {
        if (position == 1) {
            setHead(node);
            return;
        }

        Node curr = head;
        while (position-- > 1) {
            curr = curr.next;
        }

        insertBefore(curr, node);
    }

    public void removeNodesWithValue(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                remove(curr);
            }
            curr = curr.next;
        }
    }

    public void remove(Node node) {
        if (head == null) {
            return;
        }

        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            next.prev = prev;
        }
    }

    private void removeIfExists(Node node) {
        if (exists(node)) {
            remove(node);
        }
    }

    public boolean containsNodeWithValue(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private boolean exists(Node node) {
        Node curr = head;
        while (curr != null) {
            if (curr == node) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
