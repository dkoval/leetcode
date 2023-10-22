package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-score-of-a-good-subarray/">Maximum Score of a Good Subarray (Hard)</a>
 * <p>
 * You are given an array of integers nums (0-indexed) and an integer k.
 * <p>
 * The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.
 * <p>
 * Return the maximum possible score of a good subarray.
 * <p>
 * Constraints:
 * <ul>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 104
 * 0 <= k < nums.length
 */
public interface MaximumScoreOfGoodSubarray {

    int maximumScore(int[] nums, int k);

    // O(N) time | O(1) space
    class MaximumScoreOfGoodSubarrayRev1 implements MaximumScoreOfGoodSubarray {

        @Override
        public int maximumScore(int[] nums, int k) {
            int n = nums.length;

            // Idea: starting at index k, greedily expand a good subarray
            int left = k;
            int right = k;
            int maxScore = nums[k]; // max score of a subarray of length 1
            int min = nums[k];
            while (left > 0 || right < n - 1) {
                // maxScore = min(...) * length of subarray
                // maxScore is "bottlenecked" by the minimum element anyway, therefore we want to increase
                // our chances of finding a larger minimum by expanding to either left or right.
                // We know that 1 <= nums[i] <= 2 * 10^4
                int leftValue = (left - 1 >= 0) ? nums[left - 1] : Integer.MIN_VALUE;
                int rightValue = (right + 1 < n) ? nums[right + 1] : Integer.MIN_VALUE;
                if (leftValue > rightValue) {
                    // include left element
                    min = Math.min(min, leftValue);
                    left--;
                } else if (rightValue > leftValue) {
                    // include right element
                    min = Math.min(min, rightValue);
                    right++;
                } else {
                    // include both left and right elements
                    min = Math.min(min, leftValue);
                    left--;
                    right++;
                }
                maxScore = Math.max(maxScore, min * (right - left + 1));
            }
            return maxScore;
        }
    }
}
