package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class KDiffPairsInArrayInNLogNTimeWithCustomBinarySearchJava implements KDiffPairsInArray {

    @Override
    public int findPairs(@NotNull int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        Integer prev = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (prev != null && prev == nums[i]) continue;
            int index = binarySearch(nums, i + 1, nums.length - 1, nums[i] + k);
            if (index >= 0) count++;
            prev = nums[i];
        }
        return count;
    }

    private int binarySearch(int[] nums, int start, int end, int key) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
