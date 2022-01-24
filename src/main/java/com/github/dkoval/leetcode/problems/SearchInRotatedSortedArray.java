package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 5000</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 *  <li>All values of nums are unique</li>
 *  <li>nums is an ascending array that is possibly rotated</li>
 *  <li>-10^4 <= target <= 10^4</li>
 * </ul>
 */
public class SearchInRotatedSortedArray {

    // Resource: https://www.youtube.com/watch?v=QdVrY3stDD4
    // O(logN) time | O(1) space
    public int search(int[] nums, int target) {
        int n = nums.length;
        int idxOfMin = indexOfMin(nums);
        if (target >= nums[idxOfMin] && target <= nums[n - 1]) {
            return binarySearch(nums, idxOfMin, n - 1, target);
        }
        return binarySearch(nums, 0, idxOfMin - 1, target);
    }

    private int indexOfMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
