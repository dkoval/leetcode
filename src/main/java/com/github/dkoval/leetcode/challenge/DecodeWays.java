package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3902/">Decode Ways</a>
 * <p>
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <pre>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * </pre>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping
 * above (there may be multiple ways). For example, "11106" can be mapped into:
 * <ul>
 *  <li>"AAJF" with the grouping (1 1 10 6)</li>
 *  <li>"KJF" with the grouping (11 10 6)</li>
 * </ul>
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public interface DecodeWays {

    int numDecodings(String s);

    // O(N) time | O(N) space
    class DecodeWaysTopDownWithMemoization implements DecodeWays {

        @Override
        public int numDecodings(String s) {
            // DP: top-down with memoization
            int n = s.length();
            Integer[] memo = new Integer[n];
            return numDecodings(s, 0, memo);
        }

        // returns the number of ways to decode suffix s[idx:]
        private int numDecodings(String s, int idx, Integer[] memo) {
            int n = s.length();
            if (idx == n) {
                return 1;
            }

            if (s.charAt(idx) == '0') {
                return 0;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            int count = 0;

            // take 1 character ('0' got ignored earlier)
            count += numDecodings(s, idx + 1, memo);

            // take 2 characters: 1[0-9], 2[0-6]
            if (s.charAt(idx) == '1' && idx + 1 < n) {
                count += numDecodings(s, idx + 2, memo);
            }

            if (s.charAt(idx) == '2' && idx + 1 < n && s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6') {
                count += numDecodings(s, idx + 2, memo);
            }

            memo[idx] = count;
            return count;
        }
    }
}
