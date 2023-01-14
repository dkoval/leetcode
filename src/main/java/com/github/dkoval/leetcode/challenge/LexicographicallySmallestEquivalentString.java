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
}
