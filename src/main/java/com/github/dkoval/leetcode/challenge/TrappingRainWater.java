package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/">Trapping Rain Water</a>
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == height.length</li>
 *  <li>0 <= n <= 3 * 10^4</li>
 *  <li>0 <= height[i] <= 10^5</li>
 * </ul>
 */
public class TrappingRainWater {

    // O(N) time | O(N) space
    public int trap(int[] heights) {
        int n = heights.length;
        // at least 3 elevations are needed to tap some water
        if (n < 3) {
            return 0;
        }

        // maxRight[i] is the maximum number in heights[i:n-1]
        int[] maxRight = new int[n];
        maxRight[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(heights[i], maxRight[i + 1]);
        }

        // at index i, maxLeft is the maximum element in heights[0:i]
        int maxLeft = heights[0];
        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            maxLeft = Math.max(heights[i], maxLeft);
            int water = Math.min(maxLeft, maxRight[i]) - heights[i];
            total += water;
        }
        return total;
    }
}
