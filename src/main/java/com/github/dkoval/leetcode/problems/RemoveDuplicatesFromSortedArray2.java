package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">Remove Duplicates from Sorted Array II</a>
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 */
public abstract class RemoveDuplicatesFromSortedArray2 {

    public abstract int removeDuplicates(int[] nums);

    // Time Complexity: We have to iterate over all the elements in the array, the time taken here would be O(N).
    // The worst case would be when all the elements in the array are the same. In that case, we would be performing
    // N - 2 deletions thus giving us O(N^2) deletions.
    //
    // Space Complexity: O(1) since we are modifying the array in-place.
    public static class RemoveDuplicatesFromSortedArray2ByPoppingUnwantedDuplicates
            extends RemoveDuplicatesFromSortedArray2 {

        @Override
        public int removeDuplicates(int[] nums) {
            int i = 1, count = 1, n = nums.length;
            while (i < n) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                    if (count > 2) {
                        removeElement(nums, i);
                        i--;
                        n--;
                    }
                } else {
                    // Reset the count since we encountered a different element than the previous one
                    count = 1;
                }
                i++;
            }
            return n;
        }

        private void removeElement(int[] nums, int index) {
            // Overwrite the element at the given index by moving all the elements to the right of the index, one position to the left
            for (int i = index + 1; i < nums.length; i++) {
                nums[i - 1] = nums[i];
            }
        }
    }

    // Time Complexity: O(N) since we process each element exactly once.
    // Space Complexity: O(1).
    public static class RemoveDuplicatesFromSortedArray2ByOverwritingUnwantedDuplicates extends
            RemoveDuplicatesFromSortedArray2 {

        public int removeDuplicates(int[] nums) {
            // next location in the array where we can overwrite an element
            int writeIdx = 1;
            // count of a particular element in the array
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    // reset the count since we encountered a different element than the previous one
                    count = 1;
                }
                if (count <= 2) {
                    if (writeIdx != i) { // optional optimization, nums[writeIdx++] = nums[i] will work just fine
                        nums[writeIdx] = nums[i];
                    }
                    writeIdx++;
                }
            }
            return writeIdx;
        }
    }
}
