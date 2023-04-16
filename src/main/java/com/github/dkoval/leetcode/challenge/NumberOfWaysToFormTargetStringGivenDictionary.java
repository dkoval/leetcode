package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/">Number of Ways to Form a Target String Given a Dictionary (Hard)</a>
 * <p>
 * You are given a list of strings of the same length words and a string target.
 * <p>
 * Your task is to form target using the given words under the following rules:
 * <ul>
 *  <li>target should be formed from left to right.</li>
 *  <li>To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].</li>
 *  <li>Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k.
 *  In other words, all characters to the left of or at index k become unusable for every string.</li>
 *  <li>Repeat the process until you form the string target.</li>
 * </ul>
 * Notice that you can use multiple characters from the same string in words provided the conditions above are met.
 * <p>
 * Return the number of ways to form target from words. Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 1000</li>
 *  <li>1 <= words[i].length <= 1000</li>
 *  <li>All strings in words have the same length.</li>
 *  <li>1 <= target.length <= 1000</li>
 *  <li>words[i] and target contain only lowercase English letters.</li>
 * </ul>
 */
public interface NumberOfWaysToFormTargetStringGivenDictionary {

    int MOD = 1_000_000_007;

    int numWays(String[] words, String target);

    class NumberOfWaysToFormTargetStringGivenDictionaryTLE implements NumberOfWaysToFormTargetStringGivenDictionary {

        @Override
        public int numWays(String[] words, String target) {
            int t = target.length();
            int k = words[0].length();

            // DP top-down, i.e. backtracking with memoization
            Integer[][] dp = new Integer[t][k];
            return getWays(words, target, 0, 0, dp);
        }

        private int getWays(String[] words, String target, int idx, int offset, Integer[][] dp) {
            if (idx == target.length()) {
                return 1;
            }

            if (offset == words[0].length()) {
                return 0;
            }

            if (dp[idx][offset] != null) {
                return dp[idx][offset];
            }

            int count = 0;
            char c = target.charAt(idx);
            for (String word : words) {
                for (int i = offset; i < word.length(); i++) {
                    if (word.charAt(i) == c) {
                        count += getWays(words, target, idx + 1, i + 1, dp);
                        count %= MOD;
                    }
                }
            }
            return dp[idx][offset] = count;
        }
    }

    // O(W * K + T * K) time | O(T * K) space
    class NumberOfWaysToFormTargetStringGivenDictionaryPreprocessing implements NumberOfWaysToFormTargetStringGivenDictionary {

        @Override
        public int numWays(String[] words, String target) {
            int t = target.length();
            int k = words[0].length();

            // fix TLE: precompute the count of each character at each position
            // takes O(W * K) time | O(K) space, where W - number of words
            int[][] counts = new int[26][k];
            for (String word : words) {
                for (int i = 0; i < k; i++) {
                    char c = word.charAt(i);
                    counts[c - 'a'][i]++;
                }
            }

            // DP top-down, i.e. backtracking with memoization
            // takes O(T * K) time | O(T * K) space
            Integer[][] dp = new Integer[t][k];
            return getWays(counts, target, 0, 0, dp);
        }

        private int getWays(int[][] counts, String target, int idx, int offset, Integer[][] dp) {
            if (idx == target.length()) {
                return 1;
            }

            int k = counts[0].length;
            if (offset == counts[0].length) {
                return 0;
            }

            // already solved?
            if (dp[idx][offset] != null) {
                return dp[idx][offset];
            }

            long total = 0;
            char c = target.charAt(idx);

            // option #1: skip "offset" position
            total += getWays(counts, target, idx, offset + 1, dp);

            // option #2: take "offset" position
            long matches = counts[c - 'a'][offset];
            if (matches > 0) {
                total += matches * getWays(counts, target, idx + 1, offset + 1, dp);
                total %= MOD;
            }

            // cache and return the answer
            return dp[idx][offset] = (int) total;
        }
    }
}
