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
            final var t = target.length();
            final var k = words[0].length();

            // DP top-down, i.e. backtracking with memoization
            return calc(words, target, 0, 0, new Integer[t][k]);
        }

        private int calc(String[] words, String target, int index, int offset, Integer[][] dp) {
            final var t = target.length();
            final var k = words[0].length();

            if (index == target.length()) {
                return 1;
            }

            if (offset == k) {
                return 0;
            }

            // already solved?
            if (dp[index][offset] != null) {
                return dp[index][offset];
            }

            var total = 0;
            final var c = target.charAt(index);

            // option #1: take `offset`
            for (String word : words) {
                // NB. To fix TLE, precompute how many times this condition is true, then
                // total += count * calc(words, target, index + 1, offset + 1, dp);
                if (word.charAt(offset) == c) {
                    total += calc(words, target, index + 1, offset + 1, dp);
                    total %= MOD;
                }
            }

            // option #2: skip `offset`
            total += calc(words, target, index, offset + 1, dp);
            total %= MOD;

            // cache and return the answer
            return dp[index][offset] = total;
        }
    }

    // O(W * K + T * K) time | O(T * K) space
    class NumberOfWaysToFormTargetStringGivenDictionaryPreprocessing implements NumberOfWaysToFormTargetStringGivenDictionary {

        @Override
        public int numWays(String[] words, String target) {
            final var t = target.length();
            // Constraint: all strings in words have the same length.
            final var k = words[0].length();

            // fix TLE: precompute the numbers of letters at each position
            final var counts = new int[26][k];
            for (String word : words) {
                for (int offset = 0; offset < k; offset++) {
                    final var c = word.charAt(offset);
                    counts[c - 'a'][offset]++;
                }
            }

            // DP top-down, i.e. backtracking with memoization
            // takes O(T * K) time | O(T * K) space
            return calc(counts, target, 0, 0, new Integer[t][k]);
        }

        // 0 <= index < T
        // 0 <= offset < K
        private int calc(int[][] counts, String target, int index, int offset, Integer[][] dp) {
            final var t = target.length();
            final var k = counts[0].length;

            if (index == target.length()) {
                return 1;
            }

            if (offset == k) {
                return 0;
            }

            // already solved?
            if (dp[index][offset] != null) {
                return dp[index][offset];
            }

            var total = 0L;
            final var c = target.charAt(index);

            // option #1: skip "offset" position
            total += calc(counts, target, index, offset + 1, dp);

            // option #2: take "offset" position
            final var matches = counts[c - 'a'][offset];
            if (matches > 0) {
                total += (long) matches * calc(counts, target, index + 1, offset + 1, dp);
                total %= MOD;
            }

            // cache and return the answer
            return dp[index][offset] = (int) total;
        }
    }
}
