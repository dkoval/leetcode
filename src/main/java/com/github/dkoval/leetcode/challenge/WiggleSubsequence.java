package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/wiggle-subsequence/">Wiggle Subsequence</a>
 * <p>
 * Given an integer array nums, return the length of the longest wiggle sequence.
 * <p>
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between
 * positive and negative. The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately
 * positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences
 * are positive and the second because its last difference is zero.
 * <p>
 * A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 1000</li>
 * </ul>
 */
public class WiggleSubsequence {

    // O(N) time | O(1) space
    // Resource: https://www.youtube.com/watch?v=xtDu3jm5WsI
    public int wiggleMaxLength(int[] nums) {
        // a sequence with fewer than two elements is a wiggle sequence
        if (nums.length < 2) {
            return nums.length;
        }

        int i = 1;
        // skip duplicate numbers at the beginning
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }

        if (i == nums.length) {
            return 1;
        }

        // answer to the problem is the number of peaks in nums[];
        // at this stage we know that nums[] contains at least 2 elements
        int count = 2;
        boolean inc = nums[i] > nums[i - 1];
        while (i < nums.length) {
            if (inc) {
                // can an increasing sequence be further expanded?
                while (i < nums.length && nums[i] >= nums[i - 1]) {
                    i++;
                }
                if (i < nums.length) {
                    // from index i, a subsequence starts to decrease
                    count++;
                }
                inc = false;
            } else {
                // can a decreasing sequence be further expanded?
                while (i < nums.length && nums[i] <= nums[i - 1]) {
                    i++;
                }
                if (i < nums.length) {
                    // from index i, a subsequence starts to increase
                    count++;
                }
                inc = true;
            }
        }
        return count;
    }
}
