package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/reverse-degree-of-a-string/">Reverse Degree of a String</a>
 * <p>
 * Given a string s, calculate its reverse degree.
 * <p>
 * The reverse degree is calculated as follows:
 * <p>
 * For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
 * <p>
 * Sum these products for all characters in the string.
 * <p>
 * Return the reverse degree of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s contains only lowercase English letters.</li>
 * </ul>
 */
public interface ReverseDegreeOfString {

    int reverseDegree(String s);

    class ReverseDegreeOfStringRev1 implements ReverseDegreeOfString {

        @Override
        public int reverseDegree(String s) {
            final var n = s.length();

            var total = 0;
            for (var i = 0; i < n; i++) {
                total += (i + 1) * (26 - (s.charAt(i) - 'a'));
            }
            return total;
        }
    }
}
