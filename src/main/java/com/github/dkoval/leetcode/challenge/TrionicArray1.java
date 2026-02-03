package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/trionic-array-i/">Trionic Array I</a>
 * <p>
 * You are given an integer array nums of length n.
 * <p>
 * An array is trionic if there exist indices 0 < p < q < n − 1 such that:
 * <ul>
 *  <li>nums[0...p] is strictly increasing,</li>
 *  <li>nums[p...q] is strictly decreasing,</li>
 *  <li>nums[q...n − 1] is strictly increasing.</li>
 * </ul>
 * Return true if nums is trionic, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 100</li>
 *  <li>-1000 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface TrionicArray1 {

    boolean isTrionic(int[] nums);

    class TrionicArray1Rev1 implements TrionicArray1 {

        @Override
        public boolean isTrionic(int[] nums) {
            final var n = nums.length;

            for (var p = 1; p < n - 1; p++) {
                for (var q = p + 1; q < n - 1; q++) {
                    if (good(nums, p, q)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean good(int[] nums, int p, int q) {
            final var n = nums.length;
            return increasing(nums, 0, p) && decreasing(nums, p, q) && increasing(nums, q, n - 1);
        }

        private boolean increasing(int[] nums, int start, int end) {
            for (var i = start + 1; i <= end; i++) {
                if (nums[i] <= nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }

        private boolean decreasing(int[] nums, int start, int end) {
            for (var i = start + 1; i <= end; i++) {
                if (nums[i] >= nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
