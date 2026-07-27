package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Maximum Product of Two Elements in an Array</a>
 * <p>
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 500</li>
 *  <li>1 <= nums[i] <= 10^3</li>
 * </ul>
 */
public interface MaximumProductOfTwoElementsInArray {

    int maxProduct(int[] nums);

    class MaximumProductOfTwoElementsInArrayRev1 implements MaximumProductOfTwoElementsInArray {

        @Override
        public int maxProduct(int[] nums) {
            final var n = nums.length;

            // max1 < max2
            var best = 0;
            var max1 = 0;
            var max2 = 0;
            for (var x : nums) {
                var num = x - 1;
                if (num > max2) {
                    max1 = max2;
                    max2 = num;
                } else {
                    max1 = num;
                }
                best = Math.max(best, max1 * max2);
            }
            return best;
        }
    }

    class MaximumProductOfTwoElementsInArrayRev2 implements MaximumProductOfTwoElementsInArray {

        @Override
        public int maxProduct(int[] nums) {
            final var n = nums.length;

            // max1 < max2
            var max1 = 0;
            var max2 = 0;
            for (var x : nums) {
                if (x > max2) {
                    max1 = max2;
                    max2 = x;
                } else if (x > max1) {
                    max1 = x;
                }
            }
            return (max1 - 1) * (max2 - 1);
        }
    }
}
