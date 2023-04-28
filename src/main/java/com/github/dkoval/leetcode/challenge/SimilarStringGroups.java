package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/similar-string-groups/">Similar String Groups (Hard)</a>
 * <p>
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * Also two strings X and Y are similar if they are equal.
 * <p>
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
 * but "star" is not similar to "tars", "rats", or "arts".
 * <p>
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
 * Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * <p>
 * We are given a list strs of strings where every string in strs is an anagram of every other string in strs.
 * How many groups are there?
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= strs.length <= 300</li>
 *  <li>1 <= strs[i].length <= 300</li>
 *  <li>strs[i] consists of lowercase letters only.</li>
 *  <li>All words in strs have the same length and are anagrams of each other.</li>
 * </ul>
 */
public interface SimilarStringGroups {

    int numSimilarGroups(String[] strs);

    // O(N^2 * L) time | O(N) space
    class SimilarStringGroupsRev1 implements SimilarStringGroups {

        @Override
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;

            // idea: graph + connected components
            // build an edge between a pair of strs[i] and strs[j] if they are similar, i != j
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (similar(strs[i], strs[j])) {
                        adj.computeIfAbsent(i, __ -> new ArrayList<>()).add(j);
                        adj.computeIfAbsent(j, __ -> new ArrayList<>()).add(i);
                    }
                }
            }

            // count connected components
            int count = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    explore(adj, i, visited);
                    count++;
                }
            }
            return count;
        }

        private boolean similar(String s1, String s2) {
            // all words in strs have the same length and are anagrams of each other
            int len = s1.length();
            int mismatches = 0;
            for (int i = 0; i < len; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    mismatches++;
                    if (mismatches > 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void explore(Map<Integer, List<Integer>> adj, int source, boolean[] visited) {
            // BFS
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(source);
            visited[source] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (!visited[v]) {
                        q.offer(v);
                        visited[v] = true;
                    }
                }
            }
        }
    }
}
