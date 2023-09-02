package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/extra-characters-in-a-string/">Extra Characters in a String</a>
 * <p>
 * You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more
 * non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s
 * which are not present in any of the substrings.
 * <p>
 * Return the minimum number of extra characters left over if you break up s optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 50</li>
 *  <li>1 <= dictionary.length <= 50</li>
 *  <li>1 <= dictionary[i].length <= 50</li>
 * </ul>
 */
public interface ExtraCharactersInString {

    int minExtraChar(String s, String[] dictionary);

    class ExtraCharactersInStringDPTopDownRev1 implements ExtraCharactersInString {

        @Override
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();

            Set<String> words = new HashSet<>(Arrays.asList(dictionary));
            if (words.contains(s)) {
                return 0;
            }

            Integer[] dp = new Integer[n];
            return calculate(s, words, 0, dp);
        }

        // return the minimum number of extra characters left over if you break up s[start:] optimally.
        private int calculate(String s, Set<String> words, int start, Integer[] dp) {
            int n = s.length();

            // base case
            if (start == n) {
                return 0;
            }

            // already solved?
            if (dp[start] != null) {
                return dp[start];
            }

            int best = n;
            // try every prefix of s[start:]
            for (int end = start; end < n; end++) {
                int extra = calculate(s, words, end + 1, dp);
                String prefix = s.substring(start, end + 1);
                if (!words.contains(prefix)) {
                    // characters at indices start .. end weren't used
                    extra += end - start + 1;
                }
                best = Math.min(best, extra);
            }

            // cache and return the answer
            return dp[start] = best;
        }
    }

    class ExtraCharactersInStringDPTopDownRev2 implements ExtraCharactersInString {

        @Override
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();

            Set<String> words = new HashSet<>(Arrays.asList(dictionary));
            if (words.contains(s)) {
                return 0;
            }

            Integer[] dp = new Integer[n];
            return calculate(s, words, 0, dp);
        }

        private int calculate(String s, Set<String> words, int i, Integer[] dp) {
            int n = s.length();

            // base case
            if (i == n) {
                return 0;
            }

            // already solved?
            if (dp[i] != null) {
                return dp[i];
            }

            // skip s[i]
            int best = 1 + calculate(s, words, i + 1, dp);

            // try every possible prefix of s[i:]
            for (int j = i; j < n; j++) {
                String prefix = s.substring(i, j + 1);
                if (words.contains(prefix)) {
                    best = Math.min(best, calculate(s, words, j + 1, dp));
                }
            }

            // cache and return the answer
            return dp[i] = best;
        }
    }

    class ExtraCharactersInStringDPBottomUpRev1 implements ExtraCharactersInString {

        @Override
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();

            Set<String> words = new HashSet<>(Arrays.asList(dictionary));
            if (words.contains(s)) {
                return 0;
            }

            // dp[i] - min extra characters if breaking up s[i:] optimally.
            int[] dp = new int[n + 1];
            for (int start = n - 1; start >= 0; start--) {
                int best = n;
                // try every prefix of s[start:]
                for (int end = start; end < n; end++) {
                    int extra = dp[end + 1];
                    String prefix = s.substring(start, end + 1);
                    if (!words.contains(prefix)) {
                        // characters at indices start .. end weren't used
                        extra += end - start + 1;
                    }
                    best = Math.min(best, extra);
                }
                dp[start] = best;
            }
            return dp[0];
        }
    }
}
