package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">Smallest Subsequence of Distinct Characters</a>
 * <p>
 * Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface SmallestSubsequenceOfDistinctCharacters {

    String smallestSubsequence(String s);

    class SmallestSubsequenceOfDistinctCharactersRev1 implements SmallestSubsequenceOfDistinctCharacters {

        @Override
        public String smallestSubsequence(String s) {
            final var n = s.length();

            final var last = new HashMap<Character, Integer>();
            for (var i = 0; i < n; i++) {
                last.put(s.charAt(i), i);
            }

            final var stack = new ArrayDeque<Character>();
            for (var i = 0; i < n; i++) {
                if (stack.contains(s.charAt(i))) {
                    continue;
                }

                // "fix" the state of the stack
                while (!stack.isEmpty() && stack.peek() > s.charAt(i) && last.get(stack.peek()) > i) {
                    stack.pop();
                }

                stack.push(s.charAt(i));
            }

            final var sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
}
