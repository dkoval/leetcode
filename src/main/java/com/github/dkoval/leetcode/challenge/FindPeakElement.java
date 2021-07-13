package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/">Find Peak Element</a>
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>-2^31 <= nums[i] <= 2^31 - 1</li>
 *  <li>nums[i] != nums[i + 1] for all valid i</li>
 * </ul>
 */
public class FindPeakElement {

    // O(logN) time | O(1) space
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // ~ binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long prevNum = getValue(nums, mid - 1);
            long nextNum = getValue(nums, mid + 1);

            if (prevNum < nums[mid] && nums[mid] > nextNum) {
                return mid;
            }
            if (prevNum > nums[mid]) {
                // given that nums[i] != nums[i + 1] for all valid i,
                // it means that there exists at least 1 peak to the left
                right = mid - 1;
            } else if (nextNum > nums[mid]) {
                // analogously, given that nums[i] != nums[i + 1] for all valid i,
                // it means that there exists at least 1 peak to the right
                left = mid + 1;
            }
        }
        return left;
    }

    private long getValue(int[] nums, int idx) {
        if (idx >= 0 && idx < nums.length) {
            return nums[idx];
        }
        return Long.MIN_VALUE;
    }
}
