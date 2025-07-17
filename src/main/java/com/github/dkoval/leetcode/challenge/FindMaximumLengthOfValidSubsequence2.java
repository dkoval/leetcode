package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/">Find the Maximum Length of Valid Subsequence II</a>
 * <p>
 * You are given an integer array nums and a positive integer k.
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * <p>
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
 * <p>
 * Return the length of the longest valid subsequence of nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^3</li>
 *  <li>1 <= nums[i] <= 10^7</li>
 *  <li>1 <= k <= 10^3</li>
 * </ul>
 */
public interface FindMaximumLengthOfValidSubsequence2 {

    int maximumLength(int[] nums, int k);

    class FindMaximumLengthOfValidSubsequence2Rev1 implements FindMaximumLengthOfValidSubsequence2 {

        private static int mod(int x, int k) {
            // x % k
            final var ans = x % k;
            return (ans >= 0) ? ans : ans + k;
        }

        @Override
        public int maximumLength(int[] nums, int k) {
            final var n = nums.length;

            for (var i = 0; i < n; i++) {
                nums[i] %= k;
            }

            // x % k = 0 or 1, ..., (k - 1)
            var best = 0;
            for (var rem = 0; rem < k; rem++) {
                // dp[i] is the length of the longest subsequence whose last element is i
                var dp = new int[k];
                for (var curr : nums) {
                    // (prev + curr) % k = rem <=> prev = (rem - curr) % k
                    final var prev = mod(rem - curr, k);
                    // append `curr` to the longest subsequence ending with `prev`
                    dp[curr] = Math.max(dp[curr], dp[prev] + 1);
                    // track the length of the longest subsequence among all possible choices
                    best = Math.max(best, dp[curr]);
                }
            }
            return best;
        }
    }
}
