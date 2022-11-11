package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 3 * 10^4</li>
 *  <li>-100 <= nums[i] <= 100</li>
 *  <li>nums is sorted in non-decreasing order</li>
 * </ul>
 */
public interface RemoveDuplicatesFromSortedArray {

    int removeDuplicates(int[] nums);

    class RemoveDuplicatesFromSortedArrayRev1 implements RemoveDuplicatesFromSortedArray {

        @Override
        public int removeDuplicates(int[] nums) {
            int n = nums.length;

            // idea: divide array into `duplicate-free` and `everything else` parts
            int writeIdx = 1;
            int i = 1;
            while (i < n) {
                // skip over duplicates
                while (i < n && nums[i] == nums[i - 1]) {
                    i++;
                }

                if (i < n) {
                    nums[writeIdx] = nums[i];
                    i++;
                    writeIdx++;
                }
            }
            return writeIdx;
        }
    }

    class RemoveDuplicatesFromSortedArrayRev2 implements RemoveDuplicatesFromSortedArray {

        @Override
        public int removeDuplicates(int[] nums) {
            int n = nums.length;

            int writeIdx = 1;
            for (int i = 1; i < n; i++) {
                // ignore duplicates
                if (nums[i] == nums[writeIdx - 1]) {
                    continue;
                }

                nums[writeIdx] = nums[i];
                writeIdx++;
            }
            return writeIdx;
        }
    }
}
