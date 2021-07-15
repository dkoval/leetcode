package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/">Valid Triangle Number</a>
 * <p>
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 */
public class ValidTriangleNumber {

    // O(N^2) time | O(1) space
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    // Since nums[] is sorted in asc order, inequality x + nums[r] > nums[i]
                    // also hold for all x in nums[l + 1 : r - 1].
                    // The total number of (l, r) pairs that satisfy inequality nums[l] + nums[r] > nums[i] is r - l.
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
