package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/max-dot-product-of-two-subsequences/">Max Dot Product of Two Subsequences</a>
 * <p>
 * Given two arrays nums1 and nums2.
 * <p>
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 * <p>
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 500</li>
 *  <li>-1000 <= nums1[i], nums2[i] <= 1000</li>
 * </ul>
 */
public interface MaxDotProductOfTwoSubsequences {

    int maxDotProduct(int[] nums1, int[] nums2);

    // O(N1 * N2) time | O(N1 * N2) space
    class MaxDotProductOfTwoSubsequencesDPTopDown implements MaxDotProductOfTwoSubsequences {

        @Override
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            // DP top-down
            Integer[][][] dp = new Integer[n1][n2][2];
            return calculate(nums1, nums2, 0, 0, false, dp);
        }

        private int calculate(int[] nums1, int[] nums2, int i1, int i2, boolean used, Integer[][][] dp) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            if (i1 == n1 || i2 == n2) {
                return used ? 0 : Integer.MIN_VALUE;
            }

            // already solved?
            if (dp[i1][i2][used ? 1 : 0] != null) {
                return dp[i1][i2][used ? 1 : 0];
            }

            int best = Integer.MIN_VALUE;

            // option #1: take both nums1[i1] and nums2[i2]
            best = Math.max(best, nums1[i1] * nums2[i2] + calculate(nums1, nums2, i1 + 1, i2 + 1, true, dp));

            // options #2: skip nums1[i1]
            best = Math.max(best, calculate(nums1, nums2, i1 + 1, i2, used, dp));

            // option #3: skip nums2[i2]
            best = Math.max(best, calculate(nums1, nums2, i1, i2 + 1, used, dp));

            // cache and return the answer
            return dp[i1][i2][used ? 1 : 0] = best;
        }
    }
}
