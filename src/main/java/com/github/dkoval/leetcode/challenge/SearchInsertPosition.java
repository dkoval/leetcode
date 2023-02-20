package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>-104 <= nums[i] <= 10^4</li>
 *  <li>nums contains distinct values sorted in ascending order.</li>
 *  <li>-104 <= target <= 10^4</li>
 * </ul>
 */
public interface SearchInsertPosition {

    int searchInsert(int[] nums, int target);

    class SearchInsertPositionRev1 implements SearchInsertPosition {

        @Override
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            if (target > nums[n - 1]) {
                return n;
            }

            int left = 0;
            int right = n - 1;
            // condition: nums[i] >= target
            // FF...FTT...T
            //       ^ answer (upper boundary)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
