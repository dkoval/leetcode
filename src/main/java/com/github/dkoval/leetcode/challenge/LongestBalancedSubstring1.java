package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-balanced-substring-i/"> Longest Balanced Substring I</a>
 * <p>
 * You are given a string s consisting of lowercase English letters.
 * <p>
 * A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
 * <p>
 * Return the length of the longest balanced substring of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface LongestBalancedSubstring1 {

    int longestBalanced(String s);

    class LongestBalancedSubstring1Rev1 implements LongestBalancedSubstring1 {

        @Override
        public int longestBalanced(String s) {
            final var n = s.length();

            // brute force: try every substring
            var best = 0;
            for (var left = 0; left < n; left++) {
                final var freq = new int[26];
                for (var right = left; right < n; right++) {
                    freq[s.charAt(right) - 'a']++;
                    if (isBalanced(freq)) {
                        best = Math.max(best, right - left + 1);
                    }
                }
            }
            return best;
        }

        private boolean isBalanced(int[] freq) {
            var count = -1;
            for (var f : freq) {
                if (f == 0) {
                    continue;
                }

                if (count < 0) {
                    count = f;
                } else if (count != f) {
                    return false;
                }
            }
            return true;
        }
    }
}
