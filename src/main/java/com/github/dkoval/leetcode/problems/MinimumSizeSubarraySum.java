package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= target <= 10^9</li>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public interface MinimumSizeSubarraySum {

    int minSubArrayLen(int target, int[] nums);

    // O(N^2) time | O(N) space
    class MinimumSizeSubarraySumBruteForceWithPrefixSum implements MinimumSizeSubarraySum {

        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;

            // prefix sum: sum[i] = nums[0] + ... + nums[i]
            int[] sum = new int[n];
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            int ans = n + 1;
            // starting from index `start`, consider all sub-arrays of length 1, 2, ..., n
            for (int start = 0; start < n; start++) {
                for (int end = start; end < n; end++) {
                    int subarrSum = sum[end] - (start > 0 ? sum[start - 1] : 0);
                    if (subarrSum >= target) {
                        ans = Math.min(ans, end - start + 1);
                    }
                }
            }
            return (ans <= n) ? ans : 0;
        }
    }

    // Resource: https://leetcode.com/problems/minimum-size-subarray-sum/solution/
    // O(N) time | O(1) space
    class MinimumSizeSubarraySumUsingTwoPointersRev1 implements MinimumSizeSubarraySum {

        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int start = 0;
            int ans = n + 1;
            int sum = 0;
            for (int end = 0; end < n; end++) {
                sum += nums[end];
                while (sum >= target) {
                    // no better could be done with this index as the starting index
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
            }
            return (ans <= n) ? ans : 0;
        }
    }

    // O(N) time | O(1) space
    class MinimumSizeSubarraySumUsingTwoPointersRev2 implements MinimumSizeSubarraySum {

        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;

            int start = 0;
            int end = 0;

            int best = n + 1;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                // can the window be shrunk?
                while (sum >= target) {
                    best = Math.min(best, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return (best <= n) ? best : 0;
        }
    }
}
