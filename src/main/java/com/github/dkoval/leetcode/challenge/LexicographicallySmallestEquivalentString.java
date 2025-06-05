package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/lexicographically-smallest-equivalent-string/">Lexicographically Smallest Equivalent String</a>
 * <p>
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * <p>
 * We say s1[i] and s2[i] are equivalent characters.
 * <p>
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * <p>
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of
 * baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 * <p>
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s1.length, s2.length, baseStr <= 1000</li>
 *  <li>s1.length == s2.length</li>
 *  <li>s1, s2, and baseStr consist of lowercase English letters.</li>
 * </ul>
 */
public interface LexicographicallySmallestEquivalentString {

    String smallestEquivalentString(String s1, String s2, String baseStr);

    class LexicographicallySmallestEquivalentStringRev1 implements LexicographicallySmallestEquivalentString {

        @Override
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            int n = s1.length();
            Map<Character, Set<Character>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                graph.computeIfAbsent(c1, __ -> new HashSet<>()).add(c2);
                graph.computeIfAbsent(c2, __ -> new HashSet<>()).add(c1);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                char c = baseStr.charAt(i);
                sb.append(equivalent(graph, c));
            }
            return sb.toString();
        }

        private char equivalent(Map<Character, Set<Character>> graph, char c) {
            if (!graph.containsKey(c)) {
                return c;
            }

            // BFS to find the smallest equivalent character
            // slow :(
            char best = c;
            Queue<Character> q = new ArrayDeque<>();
            Set<Character> seen = new HashSet<>();
            q.offer(c);
            seen.add(c);
            while (!q.isEmpty()) {
                char u = q.poll();
                for (char v : graph.get(u)) {
                    if (!seen.contains(v)) {
                        q.offer(v);
                        seen.add(v);
                        if (v < best) {
                            best = v;
                        }
                    }
                }
            }
            return best;
        }
    }

    class LexicographicallySmallestEquivalentStringRev2 implements LexicographicallySmallestEquivalentString {

        @Override
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            int n = s1.length();
            Map<Character, SortedSet<Character>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                // merge existing equivalence classes
                if (graph.containsKey(c1) && graph.containsKey(c2)) {
                    SortedSet<Character> group1 = graph.get(c1);
                    SortedSet<Character> group2 = graph.get(c2);

                    // merge & update mapping
                    SortedSet<Character> smaller = group1.size() <= group2.size() ? group1 : group2;
                    SortedSet<Character> larger = group1.size() > group2.size() ? group1 : group2;
                    larger.addAll(smaller);
                    for (char c : smaller) {
                        graph.put(c, larger);
                    }
                }

                // form equivalence classes
                if (graph.containsKey(c1)) {
                    SortedSet<Character> group = graph.get(c1);
                    group.add(c2);
                    graph.put(c2, group);
                } else if (graph.containsKey(c2)) {
                    SortedSet<Character> group = graph.get(c2);
                    group.add(c1);
                    graph.put(c1, group);
                } else {
                    SortedSet<Character> group = new TreeSet<>(Arrays.asList(c1, c2));
                    graph.put(c1, group);
                    graph.put(c2, group);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                char c = baseStr.charAt(i);
                char x = graph.containsKey(c) ? graph.get(c).iterator().next() : c;
                sb.append(x);
            }
            return sb.toString();
        }
    }

    class LexicographicallySmallestEquivalentStringRev3 implements LexicographicallySmallestEquivalentString {

        @Override
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            final var uf = new UnionFind();
            for (var i = 0; i < s1.length(); i++) {
                uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }

            final var sb = new StringBuilder();
            for (var i = 0; i < baseStr.length(); i++) {
                final var c = (char) (uf.find(baseStr.charAt(i) - 'a') + 'a');
                sb.append(c);
            }
            return sb.toString();
        }

        static class UnionFind {
            // parent[i] is the parent of i
            final int[] parent = new int[26];

            UnionFind() {
                for (var i = 0; i < 26; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    // path compression
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            void union(int x, int y) {
                final var px = find(x);
                final var py = find(y);
                if (px == py) {
                    return;
                }

                // choose lexicographically smaller character as the root
                final var p = Math.min(px, py);
                final var c = Math.max(px, py);
                parent[c] = p;
            }
        }
    }
}
