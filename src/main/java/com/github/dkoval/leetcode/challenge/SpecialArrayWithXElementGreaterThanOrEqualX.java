package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/">Special Array With X Elements Greater Than or Equal X</a>
 * <p>
 * You are given an array nums of non-negative integers. nums is considered special if there exists a number x
 * such that there are exactly x numbers in nums that are greater than or equal to x.
 * <p>
 * Notice that x does not have to be an element in nums.
 * <p>
 * Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface SpecialArrayWithXElementGreaterThanOrEqualX {

    int specialArray(int[] nums);

    class SpecialArrayWithXElementGreaterThanOrEqualXRev1 implements SpecialArrayWithXElementGreaterThanOrEqualX {

        @Override
        public int specialArray(int[] nums) {
            int n = nums.length;

            for (int x = 1; x <= n; x++) {
                if (isGood(nums, x)) {
                    return x;
                }
            }
            return -1;
        }

        private boolean isGood(int[] nums, int x) {
            // count the number of elements in nums[] that are >= x
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            return count == x;
        }
    }

    class SpecialArrayWithXElementGreaterThanOrEqualXRev2 implements SpecialArrayWithXElementGreaterThanOrEqualX {

        @Override
        public int specialArray(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);
            int prev = -1;
            int i = 0;
            while (i < n) {
                int x = n - i;
                if ((nums[i] == x) || (x > prev && x < nums[i])) {
                    return x;
                }

                // special case: ignore duplicates to the right of index i
                while (i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }

                prev = nums[i];
                i++;
            }
            return -1;
        }
    }
}
