package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-subarrays-of-length-three-with-condition/">Count Subarrays of Length Three with Condition</a>
 * <p>
 * Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 100</li>
 *  <li-100 <= nums[i] <= 100</li>
 * </ul>
 */
public interface CountSubarraysOfLengthThreeWithCondition {

    int countSubarrays(int[] nums);

    class CountSubarraysOfLengthThreeWithConditionRev1 implements CountSubarraysOfLengthThreeWithCondition {

        @Override
        public int countSubarrays(int[] nums) {
            final var n = nums.length;

            var count = 0;
            for (var i = 0; i <= n - 3; i++) {
                if (2 * (nums[i] + nums[i + 2]) == nums[i + 1]) {
                    count++;
                }
            }
            return count;
        }
    }
}
