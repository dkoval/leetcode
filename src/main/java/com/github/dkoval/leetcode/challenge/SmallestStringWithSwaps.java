package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/smallest-string-with-swaps/">Smallest String With Swaps</a>
 * <p>
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * <p>
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * <p>
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>0 <= pairs.length <= 10^5</li>
 *  <li>0 <= pairs[i][0], pairs[i][1] < s.length</li>
 *  <li>s only contains lower case English letters</li>
 * </ul>
 */
public class SmallestStringWithSwaps {

    private static class UnionFind {
        // parent[i] is the parent of i
        final int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            // initially, i is the parent to itself
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        // Connected components grouped by their root
        // MIN heap maintains lexicographical order of characters belonging to the same component
        Map<Integer, PriorityQueue<Character>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, key -> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            char c = components.get(root).poll();
            sb.append(c);
        }
        return sb.toString();
    }
}
