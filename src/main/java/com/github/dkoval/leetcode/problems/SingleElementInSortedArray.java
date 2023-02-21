package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">Single Element in a Sorted Array</a>
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface SingleElementInSortedArray {

    int singleNonDuplicate(int[] nums);

    // O(N) time | O(1) space
    class SingleElementInSortedArrayInLinearTimeUsingXorOperator implements SingleElementInSortedArray {

        @Override
        public int singleNonDuplicate(int[] nums) {
            int ans = 0;
            for (int x : nums) {
                ans ^= x;
            }
            return ans;
        }
    }

    // O(N) time | O(1) space
    class SingleElementInSortedArrayInLinearTimeByMoving2StepsAtTime implements SingleElementInSortedArray {

        @Override
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;
            int i = 0;
            while (i + 1 < n) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
                i += 2;
            }
            return nums[i];
        }
    }

    // O(logN) time | O(1) space
    class SingleElementInSortedArrayUsingBinarySearch implements SingleElementInSortedArray {

        // Resource: https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
        @Override
        public int singleNonDuplicate(int[] nums) {
            // Example: 1, 1, 2, 3, 3, 4, 4, 8, 8
            //          <-->  ^  <-------------->
            // In the left part, the 1st instance of every element occurs at an EVEN index and the 2nd instance at an odd index.
            // In the right part though, the 1st instance of every element occurs at an ODD index and the 2nd instance occurs at an even index.
            int left = 0;
            int right = nums.length - 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        // we're in the left part, shrinking
                        left = mid + 1;
                    } else {
                        // we're in the right part, shrinking
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid] == nums[mid + 1]) {
                        // we're in the right part, shrinking
                        right = mid - 1;
                    } else {
                        // we're in the left part, shrinking
                        left = mid + 1;
                    }
                }
            }
            return nums[left];
        }
    }
}
