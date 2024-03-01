package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-odd-binary-number/">Maximum Odd Binary Number</a>
 * <p>
 * You are given a binary string s that contains at least one '1'.
 * <p>
 * You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number
 * that can be created from this combination.
 * <p>
 * Return a string representing the maximum odd binary number that can be created from the given combination.
 * <p>
 * Note that the resulting string can have leading zeros.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= s.length <= 100</li>
 * <li>s consists only of '0' and '1'</li>
 * <li>s contains at least one '1'</li>
 * </ul>
 */
public interface MaximumOddBinaryNumber {

    String maximumOddBinaryNumber(String s);

    // O(N) time | O(1) space
    class MaximumOddBinaryNumberRev1 implements MaximumOddBinaryNumber {

        @Override
        public String maximumOddBinaryNumber(String s) {
            // s contains at least one '1'
            int n = s.length();
            char[] bits = s.toCharArray();

            // count 1's
            int ones = 0;
            for (int i = 0; i < n; i++) {
                if (bits[i] == '1') {
                    bits[i] = '0';
                    ones++;
                }
            }

            // move 1's, except for 1 in the last position, to the front
            bits[n - 1] = '1';
            for (int i = 0; i < ones - 1; i++) {
                bits[i] = '1';
            }
            return String.valueOf(bits);
        }
    }
}
