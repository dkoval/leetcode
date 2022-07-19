package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3808/">Longest Increasing Subsequence</a>
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2500</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 * </ul>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public interface LongestIncreasingSubsequence {

    int lengthOfLIS(int[] nums);

    // O(N^2) time | O(N) space
    class LongestIncreasingSubsequenceDpBottomUp implements LongestIncreasingSubsequence {

        @Override
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            // dp[i] is the length of LIS ending at index i
            int[] dp = new int[n];

            int best = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                // check numbers before the i-th index to see if we can further extend a LIS ending at index i
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        // append nums[i] to LIS ending at index j
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        best = Math.max(best, dp[i]);
                    }
                }
            }
            return best;
        }
    }
}
