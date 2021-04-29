package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3725/">Find First and Last Position of Element in Sorted Array</a>
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int idx = binarySearch(nums, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }

        int[] answer = new int[2];
        // find leftmost i such that nums[i] = target
        int i = idx - 1;
        while (i >= 0 && nums[i] == nums[i + 1]) {
            i--;
        }
        answer[0] = i + 1;

        // find rightmost i such that nums[i] = target
        i = idx + 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        answer[1] = i - 1;
        return answer;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
