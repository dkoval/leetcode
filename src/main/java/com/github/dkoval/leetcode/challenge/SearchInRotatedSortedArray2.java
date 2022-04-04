package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">Search in Rotated Sorted Array II</a>
 * <p>
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * <p>
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that
 * the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * <p>
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 * <p>
 * Constraints:
 * <ul>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 * </ul>
 */
public interface SearchInRotatedSortedArray2 {

    boolean search(int[] nums, int target);

    class SearchInRotatedSortedArray2Rev1 implements SearchInRotatedSortedArray2 {

        // O(logN) time in average, O(N) time in the worst case, for example nums = [1, 1, 1, 1, 1] |
        // O(1) space
        @Override
        public boolean search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                // idea: in a rotated sorted array at least one part [l : mid] or [mid + 1 : r] is sorted
                int mid = l + (r - l) / 2;

                // found?
                if (nums[mid] == target) {
                    return true;
                }

                // check which part, i.e. left or right, is sorted
                if (nums[mid] > nums[l]) {
                    // left part is sorted, check whether target lies in this part
                    if (nums[l] <= target && nums[mid] > target) {
                        // target lies in the left part
                        r = mid - 1;
                    } else {
                        // target lies in the right part
                        l = mid + 1;
                    }
                } else if (nums[mid] < nums[l]) {
                    // right part is sorted, check whether target lies in this part
                    if (nums[mid] < target && nums[r] >= target) {
                        // target lies in the right part
                        l = mid + 1;
                    } else {
                        // target lies in the left part
                        r = mid - 1;
                    }
                } else {
                    // corner case: don't know which part to search in
                    l++;
                }
            }
            return false;
        }
    }

    class SearchInRotatedSortedArray2Rev2 implements SearchInRotatedSortedArray2 {

        // O(logN) time in average, O(N) time in the worst case, for example nums = [1, 1, 1, 1, 1] |
        // O(1) space
        @Override
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                // found?
                if (nums[mid] == target) {
                    return true;
                }

                // skip over duplicates: nums[l] == nums[mid] and/or nums[r] == nums[mid]
                while (l < mid && nums[l] == nums[mid]) {
                    l++;
                }

                while (r > mid && nums[r] == nums[mid]) {
                    r--;
                }

                // `mid` index splits nums[] into 2 parts; check which part is sorted to be able to binary search on it.
                if (nums[l] <= nums[mid]) {
                    // left part is sorted; check if `target` is within its bounds.
                    if (target >= nums[l] && target < nums[mid]) {
                        // indeed, `target` may exist in the left part
                        r = mid - 1;
                    } else {
                        // oops, search in the right part
                        l = mid + 1;
                    }
                } else {
                    // right part is sorted; check if target is within its bounds.
                    if (target > nums[mid] && target <= nums[r]) {
                        // indeed, `target` may exist in the right part
                        l = mid + 1;
                    } else {
                        // oops, search in the left part
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
