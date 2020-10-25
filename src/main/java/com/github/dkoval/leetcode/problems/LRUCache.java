package com.github.dkoval.leetcode.problems;

import java.util.HashMap;
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
public class LRUCache {
    private final Map<Integer, Node> cache = new HashMap<>();
    // most frequently used key is the first element in the list
    private final Node dummyHead;
    // least frequently used key is the first element in the list
    private final Node dummyTail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        dummyTail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // remove node from its current position and put it in front of the list
            remove(node);
            addFirst(node);
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
                // remove least frequently used element
                Node last = dummyTail.prev;
                cache.remove(last.key);
                remove(last);
            }
        }
        cache.put(key, node);
        // put new node in front of the list
        addFirst(node);
    }

    private void addFirst(Node node) {
        // before: dummyHead <-> a <-> b, after: dummyHead <-> node <-> a <-> b
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void remove(Node node) {
        // before: a <-> node <-> b, after: a <-> b
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
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
