package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 * <p>
 * We can scramble a string s to get a string t using the following algorithm:
 * <p>
 * If the length of the string is 1, stop.
 * <p>
 * If the length of the string is > 1, do the following:
 * <ul>
 *  <li>Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.</li>
 *  <li>Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.</li>
 *  <li>Apply step 1 recursively on each of the two substrings x and y.</li>
 * </ul>
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>s1.length == s2.length</li>
 *  <li>1 <= s1.length <= 30</li>
 *  <li>s1 and s2 consist of lowercase English letters.</li>
 * </ul>
 */
public interface ScrambleString {

    boolean isScramble(String s1, String s2);

    class ScrambleStringDPTopDown implements ScrambleString {

        @Override
        public boolean isScramble(String s1, String s2) {
            Map<String, Boolean> memo = new HashMap<>();
            return canScramble(s1, s2, memo);
        }

        private boolean canScramble(String s1, String s2, Map<String, Boolean> memo) {
            // precondition: len(s1) = len(s2)
            int n = s1.length();
            if (n == 1) {
                return s1.charAt(0) == s2.charAt(0);
            }

            if (s1.equals(s2)) {
                return true;
            }

            String key = s1 + "|" + s2;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // try every possible partition point
            boolean ans = false;
            for (int i = 1; i < n; i++) {
                // option #1: don't swap, meaning that
                // the first i characters of s1 must match the first i characters of s2
                // AND the last N - i characters of s1 must match the last N - i characters of s2
                if (canScramble(s1.substring(0, i), s2.substring(0, i), memo) && canScramble(s1.substring(i), s2.substring(i), memo)) {
                    ans = true;
                    break;
                }

                // option #2: swap, meaning that
                // the first i characters of s1 must match the last i characters of s2
                // AND the last N - i characters of s1 must match the first N - i characters of s2
                if (canScramble(s1.substring(0, i), s2.substring(n - i), memo) && canScramble(s1.substring(i), s2.substring(0, n - i), memo)) {
                    ans = true;
                    break;
                }
            }

            memo.put(key, ans);
            return ans;
        }
    }
}
