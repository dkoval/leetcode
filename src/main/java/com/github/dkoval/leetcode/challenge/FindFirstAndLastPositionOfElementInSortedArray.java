package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= nums.length <= 10^5</li>
 * <li>-10^9 <= nums[i] <= 10^9</li>
 * <li>nums is a non-decreasing array</li>
 * <li>-10^9 <= target <= 10^9</li>
 * </ul>
 */
public interface FindFirstAndLastPositionOfElementInSortedArray {

    int[] searchRange(int[] nums, int target);

    // O(N) time in the worst case if nums = [target, target, ..., target]
    // O(1) space
    class FindFirstAndLastPositionOfElementInSortedArrayRev1 implements FindFirstAndLastPositionOfElementInSortedArray {

        public int[] searchRange(int[] nums, int target) {
            int idx = binarySearch(nums, target);
            if (idx == -1) {
                return new int[]{-1, -1};
            }

            int[] ans = new int[]{idx, idx};

            // find leftmost i such that nums[i] = target
            while (ans[0] - 1 >= 0 && nums[ans[0] - 1] == nums[idx]) {
                ans[0]--;
            }

            // find rightmost i such that nums[i] = target
            while (ans[1] + 1 < nums.length && nums[ans[1] + 1] == nums[idx]) {
                ans[1]++;
            }

            return ans;
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
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

    // O(logN) time | O(1) space
    class FindFirstAndLastPositionOfElementInSortedArrayRev2 implements FindFirstAndLastPositionOfElementInSortedArray {

        @Override
        public int[] searchRange(int[] nums, int target) {
            return new int[]{firstIndexOf(nums, target), lastIndexOf(nums, target)};
        }

        private int firstIndexOf(int[] nums, int target) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    // not the very first occurrence of target, shift the right boundary to the left
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int lastIndexOf(int[] nums, int target) {
            int n = nums.length;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (mid == n - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    // not the very last occurrence of target, shift the left boundary to the right
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
