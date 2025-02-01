package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/special-array-i/">Special Array I</a>
 * <p>
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 * <p>
 * You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface SpecialArray1 {

    boolean isArraySpecial(int[] nums);

    class SpecialArray1Rev1 implements SpecialArray1 {

        @Override

        public boolean isArraySpecial(int[] nums) {
            final var n = nums.length;

            for (var i = 0; i < n - 1; i++) {
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    return false;
                }
            }
            return true;
        }
    }

    class SpecialArray1Rev2 implements SpecialArray1 {

        @Override
        public boolean isArraySpecial(int[] nums) {
            final var n = nums.length;

            for (var i = 0; i < n - 1; i++) {
                if (((nums[i] & 1) ^ (nums[i + 1] & 1)) == 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
