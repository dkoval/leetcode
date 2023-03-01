package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/">Sort an Array</a>
 * <p>
 * Given an array of integers nums, sort the array in ascending order and return it.
 * <p>
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 5 * 10^4</li>
 * <li>-5 * 10^4 <= nums[i] <= 5 * 10^4</li>
 * </ul>
 */
public interface SortArray {

    int[] sortArray(int[] nums);

    class SortArrayRev1 implements SortArray {

        @Override
        public int[] sortArray(int[] nums) {
            // idea: merge sort
            int n = nums.length;
            sort(nums, 0, n - 1);
            return nums;
        }

        private void sort(int[] nums, int start, int end) {
            if (start == end) {
                return;
            }

            // split phase
            int mid = start + (end - start) / 2;
            sort(nums, start, mid);
            sort(nums, mid + 1, end);

            // merge phase
            merge(nums, start, mid, end);
        }

        private void merge(int[] nums, int start, int mid, int end) {
            int n = end - start + 1;
            int[] tmp = new int[n];

            int i = start, j = mid + 1, k = 0;
            while (i <= mid && j <= end) {
                tmp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
            }

            while (i <= mid) {
                tmp[k++] = nums[i++];
            }

            while (j <= end) {
                tmp[k++] = nums[j++];
            }

            for (k = 0; k < n; k++) {
                nums[start + k] = tmp[k];
            }
        }
    }
}
