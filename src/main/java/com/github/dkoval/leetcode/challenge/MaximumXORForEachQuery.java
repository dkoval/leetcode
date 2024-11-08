package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-xor-for-each-query/">Maximum XOR for Each Query</a>
 * <p>
 * You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
 * <ul>
 *  <li>Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.</li>
 *  <li>Remove the last element from the current array nums.</li>
 * </ul>
 * Return an array answer, where answer[i] is the answer to the ith query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>nums.length == n</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= maximumBit <= 20</li>
 *  <li>0 <= nums[i] < 2maximumBit</li>
 *  <li>nums is sorted in ascending order.</li>
 * </ul>
 */
public interface MaximumXORForEachQuery {

    int[] getMaximumXor(int[] nums, int maximumBit);

    class MaximumXORForEachQueryRev1 implements MaximumXORForEachQuery {

        @Override
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int n = nums.length;

            // the total XOR of the array
            int xor = 0;
            for (int x : nums) {
                xor ^= x;
            }

            // the biggest number we can make = 2 ^ maximumBit - 1
            int biggest = (1 << maximumBit) - 1;

            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                ans[n - i - 1] = xor ^ biggest;
                // remove nums[i] from the total xor
                xor ^= nums[i];
            }
            return ans;
        }
    }
}
