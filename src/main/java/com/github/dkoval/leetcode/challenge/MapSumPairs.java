package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3832/">Map Sum Pairs</a>
 * <p>
 * Implement the MapSum class:
 * <ul>
 *  <li>MapSum() Initializes the MapSum object.</li>
 *  <li>void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.</li>
 *  <li>int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.</li>
 * </ul>
 */
public interface MapSumPairs {

    class MapSum {

        private static class TrieNode {
            final Map<Character, TrieNode> edges = new HashMap<>();
            int prefixSum = 0;
        }

        // O(N) space, where N is the size of the total input
        private final TrieNode root = new TrieNode();
        private final Map<String, Integer> entries = new HashMap<>();

        public MapSum() {
            // noop
        }

        // O(K) time
        public void insert(String key, int val) {
            int oldVal = entries.getOrDefault(key, 0);
            int delta = val - oldVal;
            entries.put(key, val);

            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                curr = curr.edges.computeIfAbsent(c, k -> new TrieNode());
                curr.prefixSum += delta;
            }
        }

        // O(K) time
        public int sum(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                curr = curr.edges.get(c);
                if (curr == null) {
                    return 0;
                }
            }
            return curr.prefixSum;
        }
    }
}
