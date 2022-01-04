package com.github.dkoval.leetcode.challenge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
        private static final int DEFAULT_SIZE = 1009; // prime number

        private static class Entry {
            final int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        private final List<Entry>[] table = new List[DEFAULT_SIZE];

        /** Initialize your data structure here. */
        public MyHashMap() {
            // nothing to do here
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            List<Entry> bucket = getBucket(key);
            if (!bucket.isEmpty()) {
                for (Entry entry : bucket) {
                    if (key == entry.key) {
                        entry.value = value;
                        return;
                    }
                }
            }
            // add a new entry if the bucket is either empty, or the given key is yet not in the bucket
            bucket.add(new Entry(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            List<Entry> bucket = getBucket(key);
            if (!bucket.isEmpty()) {
                for (Entry entry : bucket) {
                    if (key == entry.key) {
                        return entry.value;
                    }
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            List<Entry> bucket = getBucket(key);
            if (!bucket.isEmpty()) {
                Iterator<Entry> it = bucket.iterator();
                while (it.hasNext()) {
                    Entry entry = it.next();
                    if (key == entry.key) {
                        it.remove();
                        return;
                    }
                }
            }
        }

        private List<Entry> getBucket(int key) {
            int idx = key % table.length;
            List<Entry> bucket = table[idx];
            if (bucket == null) {
                bucket = new LinkedList<>();
                table[idx] = bucket;
            }
            return bucket;
        }
    }
}
