package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/">Construct the Minimum Bitwise Array I</a>
 * <p>
 * You are given an array nums consisting of n prime integers.
 * <p>
 * You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i],
 * i.e. ans[i] OR (ans[i] + 1) == nums[i].
 * <p>
 * Additionally, you must minimize each value of ans[i] in the resulting array.
 * <p>
 * If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>2 <= nums[i] <= 1000</li>
 *  <li>nums[i] is a prime number.</li>
 * </ul>
 */
public interface ConstructMinimumBitwiseArray1 {

    int[] minBitwiseArray(List<Integer> nums);

    class ConstructMinimumBitwiseArray1Rev1 implements ConstructMinimumBitwiseArray1 {

        @Override
        public int[] minBitwiseArray(List<Integer> nums) {
            final var n = nums.size();

            // 2 <= nums[i] <= 1000
            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                final var target = nums.get(i);
                var candidate = -1;
                for (var x = 0; x <= 1000; x++) {
                    if ((x | (x + 1)) == target) {
                        candidate = x;
                        break;
                    }
                }
                ans[i] = candidate;
            }
            return ans;
        }
    }
}
