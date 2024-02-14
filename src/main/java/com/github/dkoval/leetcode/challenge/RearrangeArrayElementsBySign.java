package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/rearrange-array-elements-by-sign/">Rearrange Array Elements by Sign</a>
 * <p>
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 * <p>
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 * <ul>
 *  <li>Every consecutive pair of integers have opposite signs.</li>
 *  <li>For all integers with the same sign, the order in which they were present in nums is preserved.</li>
 *  <li>The rearranged array begins with a positive integer.</li>
 * </ul>
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 2 * 10^5</li>
 *  <li>nums.length is even</li>
 *  <li>1 <= |nums[i]| <= 10^5</li>
 *  <li>nums consists of equal number of positive and negative integers</li>
 * </ul>
 */
public interface RearrangeArrayElementsBySign {

    int[] rearrangeArray(int[] nums);

    // O(N) time | O(N) space
    class RearrangeArrayElementsBySignRev1 implements RearrangeArrayElementsBySign {

        @Override
        public int[] rearrangeArray(int[] nums) {
            // nums.length is even
            // nums[] consists of equal number of positive and negative integers
            int n = nums.length;
            int g = n / 2;

            // groups[0] - positive numbers that appear in the same order as they are in nums[]
            // groups[1] - negative numbers that appear in the same order as they are in nums[]
            int[][] groups = new int[2][g];
            int positive = 0;
            int negative = 0;
            for (int x : nums) {
                if (x > 0) {
                    groups[0][positive++] = x;
                } else {
                    groups[1][negative++] = x;
                }
            }

            for (int i = 0; i < g; i++) {
                nums[2 * i] = groups[0][i];
                nums[2 * i + 1] = groups[1][i];
            }
            return nums;
        }
    }

    // O(N) time | O(N) space
    class RearrangeArrayElementsBySignRev2 implements RearrangeArrayElementsBySign {

        @Override
        public int[] rearrangeArray(int[] nums) {
            int n = nums.length;

            int[] ans = new int[n];
            int positiveIndex = 0;
            int negativeIndex = 1;
            for (int x : nums) {
                if (x > 0) {
                    ans[positiveIndex] = x;
                    positiveIndex += 2;
                } else {
                    ans[negativeIndex] = x;
                    negativeIndex += 2;
                }
            }
            return ans;
        }
    }
}