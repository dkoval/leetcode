package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">Remove Duplicates from Sorted Array</a>
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int writeIdx = 0; // divide array into `duplicate-free` and `everything else` parts
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[writeIdx]) {
                nums[++writeIdx] = nums[i];
            }
        }
        return writeIdx + 1;
    }
}
