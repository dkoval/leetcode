package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/">Minimum ASCII Delete Sum for Two Strings</a>
 * <p>
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s1.length, s2.length <= 1000</li>
 *  <li>s1 and s2 consist of lowercase English letters.</li>
 * </ul>
 */
public interface MinimumASCIIDeleteSumForTwoStrings {

    int minimumDeleteSum(String s1, String s2);

    // O(N1 * N2) time | O(N1 * N2) space
    class MinimumASCIIDeleteSumForTwoStringsDPTopDown implements MinimumASCIIDeleteSumForTwoStrings {

        @Override
        public int minimumDeleteSum(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();

            // DP top-down
            Integer[][] dp = new Integer[n1 + 1][n2 + 1];
            return calculate(s1, s2, 0, 0, dp);
        }

        // returns the answer considering suffixes s1[i:] and s2[j:]
        private int calculate(String s1, String s2, int i, int j, Integer[][] dp) {
            int n1 = s1.length();
            int n2 = s2.length();

            if (i == n1 && j == n2) {
                // nothing to do
                return 0;
            }

            // already solved?
            if (dp[i][j] != null) {
                return dp[i][j];
            }

            if (i == n1) {
                // delete rest of s2[j:]
                return dp[i][j] = s2.charAt(j) + calculate(s1, s2, i, j + 1, dp);
            }

            if (j == n2) {
                // delete rest of s1[i:]
                return dp[i][j] = s1.charAt(i) + calculate(s1, s2, i + 1, j, dp);
            }

            int best = Integer.MAX_VALUE;
            if (s1.charAt(i) == s2.charAt(j)) {
                // calculate for suffixes s1[i + 1 :] and s2[j + 1 :]
                best = Math.min(best, calculate(s1, s2, i + 1, j + 1, dp));
            }

            // option #1: delete s1[i]
            best = Math.min(best, s1.charAt(i) + calculate(s1, s2, i + 1, j, dp));

            // option #2: delete s2[j]
            best = Math.min(best, s2.charAt(j) + calculate(s1, s2, i, j + 1, dp));

            // cache and return the answer
            return dp[i][j] = best;
        }
    }
}
