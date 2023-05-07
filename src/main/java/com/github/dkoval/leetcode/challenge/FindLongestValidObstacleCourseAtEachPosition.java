package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">Find the Longest Valid Obstacle Course at Each Position</a>
 * <p>
 * You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.
 * <p>
 * For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:
 * <ul>
 *  <li>You choose any number of obstacles between 0 and i inclusive.</li>
 *  <li>You must include the ith obstacle in the course.</li>
 *  <li>You must put the chosen obstacles in the same order as they appear in obstacles.</li>
 *  <li>Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.</li>
 *  </ul>
 * Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == obstacles.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= obstacles[i] <= 10^7</li>
 * </ul>
 */
public interface FindLongestValidObstacleCourseAtEachPosition {

    int[] longestObstacleCourseAtEachPosition(int[] obstacles);

    class FindLongestValidObstacleCourseAtEachPositionRev1 implements FindLongestValidObstacleCourseAtEachPosition {

        @Override
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            // idea: harder version of LIS (the longest increasing subsequence)
            // DP + binary search
            int n = obstacles.length;

            // ans[i] is the length of LIS ending at i and including obstacles[i]
            int[] ans = new int[n];

            // dp[i] is the smallest ending value of LIS of length (i + 1)
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                // use binary search to find the insert position of x in dp
                int index = searchInsertPos(dp, obstacles[i]);
                dp[index] = obstacles[i];
                // update the answer
                ans[i] = index + 1;
            }
            return ans;
        }

        private int searchInsertPos(int[] nums, int target) {
            // condition: nums[i] > target
            // FF...FTT...T
            //       ^ answer
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    // mid might be the answer;
                    // check if there is a better option to the left of mid
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
