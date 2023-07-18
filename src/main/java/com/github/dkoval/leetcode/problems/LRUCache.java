package com.github.dkoval.leetcode.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <ul>
 *  <li>LRUCache(int capacity) Initialize the LRU cache with positive size capacity.</li>
 *  <li>int get(int key) Return the value of the key if the key exists, otherwise return -1.</li>
 *  <li>void put(int key, int value) Update the value of the key if the key exists.
 *  Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 *  evict the least recently used key.
 *  </li>
 * </ul>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= capacity <= 3000</li>
 *  <li>0 <= key <= 10^4</li>
 *  <li>0 <= value <= 10^5</li>
 *  <li>At most 2 * 10^5 calls will be made to get and put.</li>
 * </ul>
 */
public abstract class LRUCache {
    protected final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public abstract int get(int key);

    public abstract void put(int key, int value);

    public static class LRUCacheUsingDoublyLinkedListRev1 extends LRUCache {
        private final Map<Integer, Node> cache = new HashMap<>();
        // least frequently used key is the first element in the list
        private Node head;
        // most frequently used key is the last element in the list
        private Node tail;

        public LRUCacheUsingDoublyLinkedListRev1(int capacity) {
            super(capacity);
        }

        @Override
        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
                addLast(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node;
            if (cache.containsKey(key)) {
                node = cache.get(key);
                node.value = value;
                remove(node);
            } else {
                node = new Node(key, value);
                cache.put(key, node);
                if (cache.size() > capacity) {
                    // remove the least frequently used key
                    cache.remove(head.key);
                    remove(head);
                }
            }
            addLast(node);
        }

        private void addLast(Node node) {
            // H <-> ... <-> T <-> x
            if (tail != null) {
                tail.next = node;
                node.prev = tail;
            } else {
                head = node;
                node.prev = null;
            }
            tail = node;
            node.next = null;
        }

        private void remove(Node node) {
            // H <-> ... <-> x <-> ... <-> T
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                // remove head of the list
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                // remove tail of the list
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            }
        }

        private static class Node {
            final int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static class LRUCacheUsingDoublyLinkedListRev2 extends LRUCache {
        private final Map<Integer, Node> lookup = new HashMap<>();
        private Node head = new Node(-1, -1); // dummy
        private Node tail = new Node(-2, -2); // dummy

        public LRUCacheUsingDoublyLinkedListRev2(int capacity) {
            super(capacity);
            head.next = tail;
            tail.prev = head;
        }

        @Override
        public int get(int key) {
            if (lookup.containsKey(key)) {
                Node node = lookup.get(key);
                // move the node to the end of the list (most recently used)
                remove(node);
                addLast(node);
                return node.value;
            }
            return -1;
        }

        @Override
        public void put(int key, int value) {
            Node node;
            if (lookup.containsKey(key)) {
                node = lookup.get(key);
                node.value = value;
                remove(node);
            } else {
                node = new Node(key, value);
                lookup.put(key, node);
                if (lookup.size() > capacity) {
                    // remove the first node from the list (least recently used)
                    Node first = head.next;
                    lookup.remove(first.key);
                    remove(first);
                }
            }
            addLast(node);
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void addLast(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static class LRUCacheUsingLinkedHashMap extends LRUCache {
        private final Map<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCacheUsingLinkedHashMap(int capacity) {
            super(capacity);
        }

        @Override
        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                // remove-put makes the key most frequently used
                cache.remove(key);
                cache.put(key, value);
                return value;
            }
            return -1;
        }

        @Override
        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // remove-put makes the key most frequently used
                cache.remove(key);
            } else if (cache.size() == capacity) {
                // remove the least frequently used key
                Iterator<Integer> keys = cache.keySet().iterator();
                keys.next();
                keys.remove();
            }
            cache.put(key, value);
        }
    }
}
