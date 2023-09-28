package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-parity/">Sort Array By Parity</a>
 * <p>
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 5000</li>
 *  <li>0 <= nums[i] <= 5000</li>
 * </ul>
 */
public interface SortArrayByParity {

    int[] sortArrayByParity(int[] nums);

    // O(N) time | O(1) space
    class SortArrayByParityInplaceRev1 implements SortArrayByParity {

        @Override
        public int[] sortArrayByParity(int[] nums) {
            int n = nums.length;

            int writeIndex = 0;
            for (int i = n - 1; i > writeIndex; i--) {
                // skip odd numbers at the end of the array
                if (nums[i] % 2 != 0) {
                    continue;
                }

                // skip even numbers at the beginning of the array
                while (writeIndex < i && nums[writeIndex] % 2 == 0) {
                    writeIndex++;
                }

                // swap an odd number at the beginning of the array with an even number at the end of the array
                if (writeIndex < i) {
                    swap(nums, writeIndex, i);
                    writeIndex++;
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
