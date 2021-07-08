package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3807/">Maximum Length of Repeated Subarray</a>
 * <p>
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums1.length, nums2.length <= 1000</li>
 *  <li>0 <= nums1[i], nums2[i] <= 100</li>
 * </ul>
 */
public class MaximumLengthOfRepeatedSubarray {

    // O(N1 * N2) time | O(N1 * N2) space
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // dp[i][j] the maximum length of the longest common subarray of
        // nums1[0:i - 1] and nums2[0:j - 1] ending with num1[i] and nums2[j]
        int best = 0;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    best = Math.max(best, dp[i][j]);
                }
            }
        }
        return best;
    }
}
