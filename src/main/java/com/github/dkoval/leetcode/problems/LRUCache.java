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
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 * <p>
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 */
public abstract class LRUCache {

    public abstract int get(int key);

    public abstract void put(int key, int value);

    public static class LRUCacheUsingSinglyLinkedList extends LRUCache {
        private final int capacity;
        private final Map<Integer, Node> cache = new HashMap<>();
        // least frequently used key is the first element in the list
        private final Node head;
        // most frequently used key is the last element in the list
        private final Node tail;

        public LRUCacheUsingSinglyLinkedList(int capacity) {
            this.capacity = capacity;
            head = new Node(-42, -42);
            tail = new Node(+42, +42);
            head.next = tail;
            tail.prev = head;
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
                if (cache.size() == capacity) {
                    // remove the least frequently used key
                    Node firstNode = head.next;
                    remove(firstNode);
                    cache.remove(firstNode.key);
                }
            }
            addLast(node);
            cache.put(key, node);
        }

        private void remove(Node node) {
            // before: x <-> n <-> y, after: x <-> y
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addLast(Node node) {
            // before: x <-> tail, after: x <-> n <-> tail
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
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

    public static class LRUCacheUsingLinkedHashMap extends LRUCache {
        private final int capacity;
        private final Map<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCacheUsingLinkedHashMap(int capacity) {
            this.capacity = capacity;
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
