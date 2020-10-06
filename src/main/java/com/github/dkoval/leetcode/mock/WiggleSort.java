package com.github.dkoval.leetcode.mock;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/wiggle-sort/solution/">Wiggle Sort</a>
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]...
 */
public abstract class WiggleSort {

    private WiggleSort() { /* prevents instantiation from the outside */ }

    public abstract void wiggleSort(int[] nums);

    static class WiggleSortInNLogNTime extends WiggleSort {

        // Time complexity: O(NlogN)
        @Override
        public void wiggleSort(int[] nums) {
            // Sort the array first, then swap elements pair-wise starting from the second element.
            Arrays.sort(nums);
            for (int i = 1; i < nums.length - 1; i += 2) {
                swap(nums, i, i + 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    static class WiggleSortInLinearTime extends WiggleSort {

        // Time complexity: O(N)
        @Override
        public void wiggleSort(int[] nums) {
            boolean less = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (less) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                } else {
                    if (nums[i] < nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                }
                less = !less;
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
