package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/">Find the Power of K-Size Subarrays I</a>
 * <p>
 * You are given an array of integers nums of length n and a positive integer k.
 * <p>
 * The power of an array is defined as:
 * <ul>
 *  <li>Its maximum element if all of its elements are consecutive and sorted in ascending order.</li>
 *  <li>-1 otherwise.</li>
 * </ul>
 * You need to find the power of all subarrays of nums of size k.
 * <p>
 * Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == nums.length <= 500</li>
 *  <li>1 <= nums[i] <= 105</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface FindPowerOfKSizeSubarrays1 {

    int[] resultsArray(int[] nums, int k);

    class FindPowerOfKSizeSubarrays1Rev1 implements FindPowerOfKSizeSubarrays1 {

        @Override
        public int[] resultsArray(int[] nums, int k) {
            int n = nums.length;

            // Brute force: examine every window of size k
            int[] ans = new int[n - k + 1];
            for (int start = 0; start <= n - k; start++) {
                boolean good = true;
                for (int i = start; i < start + k - 1; i++) {
                    if (nums[i] >= nums[i + 1] || nums[i + 1] - nums[i] > 1) {
                        ans[start] = -1;
                        good = false;
                        break;
                    }
                }

                if (good) {
                    ans[start] = nums[start + k - 1];
                }
            }
            return ans;
        }
    }
}
