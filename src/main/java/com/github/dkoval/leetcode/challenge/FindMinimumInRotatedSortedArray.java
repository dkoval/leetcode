package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Find Minimum in Rotated Sorted Array</a>
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * <p>
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 */
public interface FindMinimumInRotatedSortedArray {

    int findMin(int[] nums);

    class FindMinimumInRotatedSortedArrayRev1 implements FindMinimumInRotatedSortedArray {

        @Override
        public int findMin(int[] nums) {
            var left = 0;
            var right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    // we're in the 1st half of the array;
                    // mid is not the answer
                    left = mid + 1;
                } else {
                    // we're in the 2nd half of the array;
                    // mid might be the answer, check if there is a better option to the left of it
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    class FindMinimumInRotatedSortedArrayRev2 implements FindMinimumInRotatedSortedArray {

        @Override
        public int findMin(int[] nums) {
            final var n = nums.length;

            if (nums[0] < nums[n - 1]) {
                return nums[0];
            }

            var left = 0;
            var right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[0] <= nums[mid]) {
                    // we're in the 1st half of the array;
                    // mid is not the answer
                    left = mid + 1;
                } else {
                    // we're in the 2nd half of the array;
                    // mid might be the answer, check if there is a better option to the left of it
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
