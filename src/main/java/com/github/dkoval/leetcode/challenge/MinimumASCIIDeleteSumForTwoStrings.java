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
            final var n1 = s1.length();
            final var n2 = s2.length();

            // DP top-down
            final var dp = new Integer[n1 + 1][n2 + 1];
            return calculate(s1, s2, 0, 0, dp);
        }

        // returns the answer considering suffixes s1[index1:] and s2[index2:]
        private int calculate(String s1, String s2, int index1, int index2, Integer[][] dp) {
            final var n1 = s1.length();
            final var n2 = s2.length();

            // base case
            if (index1 == n1 && index2 == n2) {
                // nothing to do
                return 0;
            }

            // already solved?
            if (dp[index1][index2] != null) {
                return dp[index1][index2];
            }

            // corner case #1
            if (index1 == n1) {
                // delete rest of s2[index2:]
                return dp[index1][index2] = s2.charAt(index2) + calculate(s1, s2, index1, index2 + 1, dp);
            }

            // corner case #2
            if (index2 == n2) {
                // delete rest of s1[index1:]
                return dp[index1][index2] = s1.charAt(index1) + calculate(s1, s2, index1 + 1, index2, dp);
            }

            var best = Integer.MAX_VALUE;
            if (s1.charAt(index1) == s2.charAt(index2)) {
                // nothing to delete, calculate the answer for prefixes s1[index1 + 1 :] and s2[index2 + 1 :]
                best = Math.min(best, calculate(s1, s2, index1 + 1, index2 + 1, dp));
            } else {
                // option #1: delete s1[index1] only
                best = Math.min(best, s1.charAt(index1) + calculate(s1, s2, index1 + 1, index2, dp));

                // option #2: delete s2[index2] only
                best = Math.min(best, s2.charAt(index2) + calculate(s1, s2, index1, index2 + 1, dp));
            }

            // cache and return the answer
            return dp[index1][index2] = best;
        }
    }
}
