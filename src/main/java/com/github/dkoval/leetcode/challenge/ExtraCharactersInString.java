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

    class ExtraCharactersInStringDPTopDown implements ExtraCharactersInString {

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
            for (int end = start; end < n; end++) {
                String subs = s.substring(start, end + 1);
                int curr = calculate(s, words, end + 1, dp);
                if (!words.contains(subs)) {
                    // characters at indices [start : end] weren't used
                    curr += end - start + 1;
                }
                best = Math.min(best, curr);
            }
            return dp[start] = best;
        }
    }
}
