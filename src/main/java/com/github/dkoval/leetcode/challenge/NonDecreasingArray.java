package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/non-decreasing-array/>Non-decreasing Array</a>
 * <p>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 10^4</li>
 * <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface NonDecreasingArray {

    boolean checkPossibility(int[] nums);

    // O(N) time | O(1) space
    class NonDecreasingArrayRev1 implements NonDecreasingArray {

        @Override
        public boolean checkPossibility(int[] nums) {
            int n = nums.length;
            boolean changed = false;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (changed) {
                        return false;
                    }

                    // Note: don't technically need to even update nums[i] for the algorithm to work;
                    // However, updating nums[i + 1] is important.
                    if (i > 0) {
                        if (nums[i - 1] > nums[i + 1]) {
                            // case #1: prev > next
                            // [..., 3, x, 2, ...] -> [..., 3, x, _x_, ...]
                            nums[i + 1] = nums[i];
                        } else if (nums[i - 1] <= nums[i + 1]) {
                            // case #2: prev < next
                            // [..., 3, x, 4, ...] -> [..., 3, _4_, 4, ...]
                            // case #3: prev == next
                            // [..., 3, x, 3, ...] -> [..., 3, _3_, 3, ...]
                            nums[i] = nums[i + 1];
                        }
                    } else {
                        // i == 0
                        nums[i] = nums[i + 1];
                    }
                    changed = true;
                }
            }
            return true;
        }
    }

    // O(N) time | O(1) space
    class NonDecreasingArrayRev2 implements NonDecreasingArray {

        @Override
        public boolean checkPossibility(int[] nums) {
            // Idea of the algorithm
            // 1. Invariant to keep nums[] sorted in non-decreasing order: nums[i - 1] <= nums[i] <= nums[i + 1]
            // 2. It's allowed to "fix" at most 1 element in nums[].
            boolean changedOneElement = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (changedOneElement) {
                        return false;
                    }
                    // [..., 3, 4, 2, ...] -> [..., 3, 4, 4, ...]
                    //       |  ^  |                |  ^  |
                    if (i > 0 && nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    }
                    changedOneElement = true;
                }
            }
            return true;
        }
    }
}
