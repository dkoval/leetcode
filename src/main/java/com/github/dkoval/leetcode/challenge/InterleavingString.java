package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/interleaving-string/">Interleaving String</a>
 * <p>
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * <pre>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * </pre>
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * Note: a + b is the concatenation of strings a and b.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= s1.length, s2.length <= 100</li>
 *  <li>0 <= s3.length <= 200</li>
 *  <li>s1, s2, and s3 consist of lowercase English letters</li>
 * </ul>
 */
public interface InterleavingString {

    boolean isInterleave(String s1, String s2, String s3);

    // O(N1 * N2) time | O(N1 * N2) space, where N2 and N2 are lengths of s1 and s2 respectively
    class InterleavingStringTopDown implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            // DP: top-down with memoization
            return checkIfInterleave(s1, 0, s2, 0, s3, new HashMap<>());
        }

        private boolean checkIfInterleave(String s1, int idx1, String s2, int idx2, String s3, Map<String, Boolean> memo) {
            String key = idx1 + "|" + idx2;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // position in s3 we're currently trying to place a char at from either s1 or s2
            int idx3 = idx1 + idx2;

            // base case
            if (idx3 == s3.length()) {
                return true;
            }

            // option #1: take s1's char
            if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3) && checkIfInterleave(s1, idx1 + 1, s2, idx2, s3, memo)) {
                memo.put(key, true);
                return true;
            }

            // option #2: take s2's char
            if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3) && checkIfInterleave(s1, idx1, s2, idx2 + 1, s3, memo)) {
                memo.put(key, true);
                return true;
            }

            memo.put(key, false);
            return false;
        }
    }

    // O(N1 * N2) time | O(N1 * N2) space, where N2 and N2 are lengths of s1 and s2 respectively
    class InterleavingStringBottomUp implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
            if (n1 + n2 != n3) {
                return false;
            }

            // dp[idx1][idx2] denotes whether s1[0:idx1 - 1] and s2[0:idx2 - 1] interleave to form s3[0:idx1 + idx2 - 1],
            // where idx1 = 1..n1, idx2 = 1..n2
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            // special case where s1 = "", s2 = "", s3 = ""
            dp[0][0] = true;

            // fill in the 1st column: case where s2 = ""
            for (int idx1 = 1; idx1 <= n1; idx1++) {
                dp[idx1][0] = dp[idx1 - 1][0] && (s1.charAt(idx1 - 1) == s3.charAt(idx1 - 1));
            }

            // fill in the 1st row: case where s1 = ""
            for (int idx2 = 1; idx2 <= n2; idx2++) {
                dp[0][idx2] = dp[0][idx2 - 1] && (s2.charAt(idx2 - 1) == s3.charAt(idx2 - 1));
            }

            for (int idx1 = 1; idx1 <= n1; idx1++) {
                for (int idx2 = 1; idx2 <= n2; idx2++) {
                    int idx3 = idx1 + idx2;
                    dp[idx1][idx2] = (dp[idx1 - 1][idx2] && (s1.charAt(idx1 - 1) == s3.charAt(idx3 - 1)))
                            || (dp[idx1][idx2 - 1] && (s2.charAt(idx2 - 1) == s3.charAt(idx3 - 1)));
                }
            }
            return dp[n1][n2];
        }
    }

    // O(N1 * N2) time | O(min(N1 * N2)) space, where N2 and N2 are lengths of s1 and s2 respectively
    class InterleavingStringBottomUpSpaceOptimized implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            String longer = s1.length() > s2.length() ? s1 : s2;
            String shorter = s1.length() <= s2.length() ? s1 : s2;
            return isInterleaveInternal(longer, shorter, s3);
        }

        private boolean isInterleaveInternal(String s1, String s2, String s3) {
            int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
            if (n1 + n2 != n3) {
                return false;
            }

            boolean[] currRow = new boolean[n2 + 1];
            // special case where s1 = "", s2 = "", s3 = ""
            currRow[0] = true;

            // fill in 1st row: case where s1 = ""
            for (int idx2 = 1; idx2 <= n2; idx2++) {
                currRow[idx2] = currRow[idx2 - 1] && (s2.charAt(idx2 - 1) == s3.charAt(idx2 - 1));
            }

            for (int idx1 = 1; idx1 <= n1; idx1++) {
                currRow[0] = currRow[0] && (s1.charAt(idx1 - 1) == s3.charAt(idx1 - 1));
                boolean prevCol = currRow[0];
                for (int idx2 = 1; idx2 <= n2; idx2++) {
                    int idx3 = idx1 + idx2;
                    currRow[idx2] = (currRow[idx2] && (s1.charAt(idx1 - 1) == s3.charAt(idx3 - 1)))
                            || (prevCol && (s2.charAt(idx2 - 1) == s3.charAt(idx3 - 1)));
                    prevCol = currRow[idx2];
                }
            }
            return currRow[n2];
        }
    }
}
