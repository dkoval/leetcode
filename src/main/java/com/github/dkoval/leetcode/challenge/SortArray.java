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

        private void sort(int[] nums, int left, int right) {
            // base case
            if (left == right) {
                return;
            }

            // split phase
            int mid = left + (right - left) / 2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);

            // merge phase
            merge(nums, left, mid, right);
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int n = right - left + 1;
            int[] tmp = new int[n];

            int i = left;
            int j = mid + 1;
            int k = 0;
            while (i <= mid && j <= right) {
                tmp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
            }

            while (i <= mid) {
                tmp[k++] = nums[i++];
            }

            while (j <= right) {
                tmp[k++] = nums[j++];
            }

            // at this stage, tmp[] is sorted;
            // replace nums[left : right] with tmp[]
            for (k = 0; k < n; k++) {
                nums[left + k] = tmp[k];
            }
        }
    }
}
