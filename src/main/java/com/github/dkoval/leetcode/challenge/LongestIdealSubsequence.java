package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-ideal-subsequence/">Longest Ideal Subsequence</a>
 * <p>
 * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following
 * conditions are satisfied:
 * <p>
 * t is a subsequence of the string s.
 * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
 * Return the length of the longest ideal string.
 * <p>
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing
 * the order of the remaining characters.
 * <p>
 * Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z'
 * is 25, not 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>0 <= k <= 25</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
 */
public interface LongestIdealSubsequence {

    int longestIdealString(String s, int k);

    class LongestIdealSubsequenceDPBottomUpRev1 implements LongestIdealSubsequence {

        @Override
        public int longestIdealString(String s, int k) {
            int n = s.length();

            // Given an index i of the input string s,
            // dp[c] represents the length of the longest ideal subsequence that ends a c,
            // for any character c that occurs before s[i], where c is in ['a'..'z']
            Map<Character, Integer> dp = new HashMap<>();

            int best = 0;
            for (int i = 0; i < n; i++) {
                int currLength = 1;
                // try to append s[i] to any previous subsequence
                for (Map.Entry<Character, Integer> entry : dp.entrySet()) {
                    char c = entry.getKey();
                    int prevLength = entry.getValue();

                    int diff = Math.abs(s.charAt(i) - c);
                    if (diff <= k) {
                        currLength = Math.max(currLength, prevLength + 1);
                    }
                }
                best = Math.max(best, currLength);
                dp.put(s.charAt(i), currLength);
            }
            return best;
        }
    }

    class LongestIdealSubsequenceDPBottomUpRev2 implements LongestIdealSubsequence {

        @Override
        public int longestIdealString(String s, int k) {
            int n = s.length();

            // Given an index i of the input string s,
            // dp[c] represents the length of the longest ideal subsequence that ends a c,
            // for any character c that occurs before s[i], where c is in ['a'..'z'].
            // c = 0 -> 'a', c = 1 -> 'b', ..., c = 25 -> 'z'
            int[] dp = new int[26];

            int best = 0;
            for (int i = 0; i < n; i++) {
                int currLength = 1;
                // try to append s[i] to any previous subsequence
                for (int j = 0; j < 26; j++) {
                    char c = (char)('a' + j);
                    int diff = Math.abs(s.charAt(i) - c);
                    if (diff <= k) {
                        currLength = Math.max(currLength, dp[j] + 1);
                    }
                }

                int index = s.charAt(i) - 'a';
                dp[index] = Math.max(dp[index], currLength);
                best = Math.max(best, dp[index]);
            }
            return best;
        }
    }
}
