package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/">Sum of All Subset XOR Totals</a>
 * <p>
 * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
 * <p>
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
 * <p>
 * Given an array nums, return the sum of all XOR totals for every subset of nums.
 * <p>
 * Note: Subsets with the same elements should be counted multiple times.
 * <p>
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 12</li>
 *  <li>1 <= nums[i] <= 20</li>
 * </ul>
 */
public interface SumOfAllSubsetXORTotals {

    int subsetXORSum(int[] nums);

    class SumOfAllSubsetXORTotalsRev1 implements SumOfAllSubsetXORTotals {

        @Override
        public int subsetXORSum(int[] nums) {
            return calc(nums, 0, 0);
        }

        private int calc(int[] nums, int index, int xorTotal) {
            if (index == nums.length) {
                return xorTotal;
            }

            int sum = 0;
            // option #1: include nums[i]
            sum += calc(nums, index + 1, xorTotal ^ nums[index]);
            // option #1: exclude nums[i]
            sum += calc(nums, index + 1, xorTotal);
            return sum;
        }
    }
}
