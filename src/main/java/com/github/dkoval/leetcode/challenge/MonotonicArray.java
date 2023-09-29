package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/monotonic-array/">Monotonic Array</a>
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * <p>
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MonotonicArray {

    boolean isMonotonic(int[] nums);

    // O(N) time | O(1) space
    class MonotonicArrayRev1 implements MonotonicArray {

        @Override
        public boolean isMonotonic(int[] nums) {
            int n = nums.length;

            if (n <= 2) {
                return true;
            }

            // skip equal numbers at the beginning of the array
            int i = 1;
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }

            if (i == n) {
                return true;
            }

            //  0 - stays flat
            // +1 - increasing
            // -1 - decreasing
            int direction = signum(nums[i] - nums[i - 1]);
            while (i < n) {
                // positive * positive = positive
                // negative * negative = positive
                if (signum(nums[i] - nums[i - 1]) * direction < 0) {
                    return false;
                }
                i++;
            }
            return true;
        }

        private int signum(int x) {
            if (x == 0) {
                return 0;
            }
            return (x > 0) ? 1 : -1;
        }
    }
}
