package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3990/">Sort Array By Parity II</a>
 * <p>
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 * <p>
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 * <p>
 * Return any answer array that satisfies this condition.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 2 * 10^4</li>
 *  <li>nums.length is even</li>
 *  <li>Half of the integers in nums are even</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 * <p>
 * Follow Up: Could you solve it in-place?
 */
public interface SortArrayByParity2 {

    int[] sortArrayByParityII(int[] nums);

    class SortArrayByParity2UsingTwoQueues implements SortArrayByParity2 {

        @Override
        public int[] sortArrayByParityII(int[] nums) {
            Queue<Integer> evens = new LinkedList<>();
            Queue<Integer> odds = new LinkedList<>();
            for (int x : nums) {
                if (x % 2 == 0) {
                    evens.add(x);
                } else {
                    odds.add(x);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                int x = (i % 2 == 0) ? evens.poll() : odds.poll();
                nums[i] = x;
            }
            return nums;
        }
    }

    class SortArrayByParity2Inplace implements SortArrayByParity2 {

        @Override
        public int[] sortArrayByParityII(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int parity = i % 2;
                if (nums[i] % 2 != parity) {
                    findAndReplace(nums, i, parity);
                }
            }
            return nums;
        }

        private void findAndReplace(int[] nums, int i, int parity) {
            int j = i + 1;
            while (j < nums.length && nums[j] % 2 != parity) {
                j++;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
