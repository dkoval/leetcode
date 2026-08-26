package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/">Shortest and Lexicographically Smallest Beautiful String</a>
 * <p>
 * You are given a binary string s and a positive integer k.
 * <p>
 * A substring of s is beautiful if the number of 1's in it is exactly k.
 * <p>
 * Let len be the length of the shortest beautiful substring.
 * <p>
 * Return the lexicographically smallest beautiful substring of string s with length equal to len.
 * If s doesn't contain a beautiful substring, return an empty string.
 * <p>
 * A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ,
 * a has a character strictly larger than the corresponding character in b.
 * <p>
 * For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character,
 * and d is greater than c.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>1 <= k <= s.length</li>
 * </ul>
 */
public interface ShortestAndLexicographicallySmallestBeautifulString {

    String shortestBeautifulSubstring(String s, int k);

    class ShortestAndLexicographicallySmallestBeautifulStringRev1 implements ShortestAndLexicographicallySmallestBeautifulString {

        @Override
        public String shortestBeautifulSubstring(String s, int k) {
            final var n = s.length();

            var best = "";
            var left = 0;
            var count = 0;
            for (var right = 0; right < n; right++) {
                count += s.charAt(right) - '0';
                if (count < k) {
                    continue;
                }

                best = stripLeadingZeros(smallest(best, s.substring(left, right + 1)));
                while (left <= right && (count == k || s.charAt(left) == '0')) {
                    count -= s.charAt(left) - '0';
                    left++;
                }
            }
            return best;
        }

        private String smallest(String current, String candidate) {
            if (current.isEmpty()) {
                return candidate;
            }

            if (candidate.length() != current.length()) {
                return (candidate.length() < current.length()) ? candidate : current;
            }

            return (candidate.compareTo(current) < 0) ? candidate : current;
        }

        private String stripLeadingZeros(String s) {
            var left = 0;
            while (left < s.length() && s.charAt(left) == '0') {
                left++;
            }
            return s.substring(left);
        }
    }
}
