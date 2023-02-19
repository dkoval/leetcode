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
public interface SearchInRotatedSortedArray {

    int search(int[] nums, int target);

    class SearchInRotatedSortedArrayByChoosingSortedPartRev1 implements SearchInRotatedSortedArray {

        // O(logN) time | O(1) space
        @Override
        public int search(int[] nums, int target) {
            int n = nums.length;

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                // which sorted portion of the array are we currently in?
                if (nums[0] <= nums[mid]) {
                    // left portion
                    if (target > nums[mid]) {
                        left = mid + 1;
                    } else if (target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // right portion
                    if (target < nums[mid]) {
                        right = mid - 1;
                    } else if (target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    class SearchInRotatedSortedArrayByChoosingSortedPartRev2 implements SearchInRotatedSortedArray {

        // O(logN) time | O(1) space
        @Override
        public int search(int[] nums, int target) {
            int n = nums.length;

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                // found?
                if (nums[mid] == target) {
                    return mid;
                }

                // `mid` index splits nums[] into 2 parts; check which part is sorted to be able to binary search on it.
                if (nums[left] <= nums[mid]) {
                    // left part is sorted; check if `target` is within its bounds.
                    if (target >= nums[left] && target < nums[mid]) {
                        // indeed, `target` may exist in the left part
                        right = mid - 1;
                    } else {
                        // oops, search in the right part
                        left = mid + 1;
                    }
                } else {
                    // right part is sorted; check if target is within its bounds.
                    if (target > nums[mid] && target <= nums[right]) {
                        // indeed, `target` may exist in the right part
                        left = mid + 1;
                    } else {
                        // oops, search in the left part
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    class SearchInRotatedSortedArrayByFindingIndexOfPivot implements SearchInRotatedSortedArray {

        // Resource: https://www.youtube.com/watch?v=QdVrY3stDD4
        // O(logN) time | O(1) space
        @Override
        public int search(int[] nums, int target) {
            int n = nums.length;
            int idxOfMin = findPivot(nums);
            if (target >= nums[idxOfMin] && target <= nums[n - 1]) {
                return binarySearch(nums, idxOfMin, n - 1, target);
            }
            return binarySearch(nums, 0, idxOfMin - 1, target);
        }

        private int findPivot(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= nums[right]) {
                    // answer is to the right of `mid` index
                    left = mid + 1;
                } else {
                    // nums[mid] is a possible answer as well as numbers to the left of `mid` index
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
}
