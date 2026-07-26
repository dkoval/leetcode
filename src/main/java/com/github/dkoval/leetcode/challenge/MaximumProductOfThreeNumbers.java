package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/">Maximum Product of Three Numbers</a>
 * <p>
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 10^4</li>
 *  <li>-1000 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface MaximumProductOfThreeNumbers {

    int maximumProduct(int[] nums);

    class MaximumProductOfThreeNumbersRev1 implements MaximumProductOfThreeNumbers {

        @Override
        public int maximumProduct(int[] nums) {
            final var n = nums.length;

            Arrays.sort(nums);
            return Math.max(
                    nums[0] * nums[1] * nums[n - 1],
                    nums[n - 1] * nums[n - 2] * nums[n - 3]
            );
        }
    }
}
