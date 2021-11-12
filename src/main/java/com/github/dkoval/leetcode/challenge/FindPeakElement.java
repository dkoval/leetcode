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

    // Resource: https://www.youtube.com/watch?v=L7gNay1c4ak
    // O(logN) time | O(1) space
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // ~ binary search
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
