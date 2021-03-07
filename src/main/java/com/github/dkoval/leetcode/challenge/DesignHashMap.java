package com.github.dkoval.leetcode.challenge;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3663/">Design HashMap</a>
 * <p>
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <ul>
 *  <ul>put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.</ul>
 *  <ul>get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.</ul>
 *  <ul>remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.</ul>
 * </ul>
 * Note:
 * <ul>
 *  <li>All keys and values will be in the range of [0, 1000000].</li>
 *  <li>The number of operations will be in the range of [1, 10000].</li>
 * </ul>
 * Please do not use the built-in HashMap library.
 */
public class DesignHashMap {

    public static class MyHashMap {
        private static final int DEFAULT_SIZE = 1000;

        private final LinkedList<Entry>[] table = new LinkedList[DEFAULT_SIZE];

        private static class Entry {
            final int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        /** Initialize your data structure here. */
        public MyHashMap() {
            // NOOP
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = key % table.length;
            LinkedList<Entry> bucket = table[idx];
            if (bucket != null) {
                for (Entry entry : bucket) {
                    if (entry.key == key) {
                        entry.value = value;
                        return;
                    }
                }
            } else {
                bucket = new LinkedList<>();
                table[idx] = bucket;
            }
            bucket.add(new Entry(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = key % table.length;
            LinkedList<Entry> bucket = table[idx];
            if (bucket != null) {
                for (Entry entry : bucket) {
                    if (entry.key == key) {
                        return entry.value;
                    }
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = key % table.length;
            LinkedList<Entry> bucket = table[idx];
            if (bucket != null) {
                Iterator<Entry> it = bucket.iterator();
                while (it.hasNext()) {
                    Entry entry = it.next();
                    if (entry.key == key) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }
}
