package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3796/">Max Consecutive Ones III</a>
 * <p>
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnes3 {

    // O(N) time | O(1) space
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int numZerosUsed = 0;
        int longest = 0;
        while (right < n) {
            if (nums[right] == 0) {
                numZerosUsed++;
            }

            // preserve the invariant - you can have at most k 0's in nums[left:right] window
            while (numZerosUsed > k) {
                if (nums[left] == 0) {
                    numZerosUsed--;
                }
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}
