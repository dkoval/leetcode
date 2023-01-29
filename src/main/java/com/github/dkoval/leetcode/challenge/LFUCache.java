package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lfu-cache/">LFU Cache (Hard)</a>
 * <p>
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * <p>
 * Implement the LFUCache class:
 * <ul>
 *  <li>LFUCache(int capacity) Initializes the object with the capacity of the data structure.</li>
 *  <li>int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.</li>
 *  <li>
 *  void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 *  When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
 *  For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 *  To determine the least frequently used key, a use counter is maintained for each key in the cache.
 *  The key with the smallest use counter is the least frequently used key.
 *  </li>
 * </ul>
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= capacity <= 10^4</li>
 *  <li>0 <= key <= 10^5</li>
 *  <li>0 <= value <= 10^9</li>
 *  <li>At most 2 * 10^5 calls will be made to get and put.</li>
 * </ul>
 */
public abstract class LFUCache {
    protected int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public abstract int get(int key);

    public abstract void put(int key, int value);

    static class LFUCacheRev1 extends LFUCache {
        // key -> value
        private final Map<Integer, Integer> cache = new HashMap<>();
        // key -> use counter
        private final Map<Integer, Integer> counts = new HashMap<>();
        // use counter -> LRU keys (LinkedHashSet maintains the order of keys as we use them. The LRU key is the first element of the set.)
        private final Map<Integer, LinkedHashSet<Integer>> buckets = new HashMap<>();
        // the minimum use counter so far
        private int minCount = Integer.MAX_VALUE;

        public LFUCacheRev1(int capacity) {
            super(capacity);
        }

        @Override
        public int get(int key) {
            if (cache.containsKey(key)) {
                updateCounts(key);
                return cache.get(key);
            }
            return -1;
        }

        @Override
        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }

            if (!cache.containsKey(key) && cache.size() == capacity) {
                // Invalidate and remove the least frequently used key, then insert a new key -> value.
                // For this problem, if two or more keys have the same frequency, the least recently used key would be invalidated.
                Iterator<Integer> keys = buckets.get(minCount).iterator();
                int keyToRemove = keys.next();
                keys.remove();
                counts.remove(keyToRemove);
                cache.remove(keyToRemove);
            }

            updateCounts(key);
            cache.put(key, value);
        }

        private void updateCounts(int key) {
            int count = counts.getOrDefault(key, 0);
            if (count > 0) {
                buckets.get(count).remove(key);
                if (minCount == count && buckets.get(count).isEmpty()) {
                    minCount++;
                }
            }

            count++;
            minCount = Math.min(minCount, count);
            counts.put(key, count);
            buckets.computeIfAbsent(count, __ -> new LinkedHashSet<>()).add(key);
        }
    }
}
