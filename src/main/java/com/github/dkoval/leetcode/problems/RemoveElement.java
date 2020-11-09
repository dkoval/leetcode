package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public int removeElement(int[] nums, int val) {
        int writeIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (writeIdx != i) {
                    nums[writeIdx] = nums[i];
                }
                writeIdx++;
            }
        }
        return writeIdx;
    }
}
