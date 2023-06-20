package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/k-radius-subarray-averages/">K Radius Subarray Averages</a>
 * <p>
 * You are given a 0-indexed array nums of n integers, and an integer k.
 * <p>
 * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements
 * in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i,
 * then the k-radius average is -1.
 * <p>
 * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
 * <p>
 * The average of x elements is the sum of the x elements divided by x, using integer division.
 * The integer division truncates toward zero, which means losing its fractional part.
 * <p>
 * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= nums[i], k <= 10^5</li>
 * </ul>
 */
public interface KRadiusSubarrayAverages {

    int[] getAverages(int[] nums, int k);

    // O(N) time | O(1) extra space
    class KRadiusSubarrayAveragesRev1 implements KRadiusSubarrayAverages {
        @Override
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;

            // idea: sliding window + running sum
            int[] ans = new int[n];

            int size = 2 * k + 1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                ans[i] = -1;
                sum += nums[i];
                if (i >= size - 1)  {
                    // remove the first element of the previous window
                    sum -= (i >= size) ? nums[i - size] : 0;
                    ans[i - k] = (int)(sum / size);
                }
            }
            return ans;
        }
    }
}
