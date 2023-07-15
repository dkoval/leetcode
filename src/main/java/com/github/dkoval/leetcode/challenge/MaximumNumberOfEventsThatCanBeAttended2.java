package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/">Maximum Number of Events That Can Be Attended II (Hard)</a>
 * <p>
 * You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi,
 * and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents
 * the maximum number of events you can attend.
 * <p>
 * You can only attend one event at a time. If you choose to attend an event, you must attend the entire event.
 * Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.
 * <p>
 * Return the maximum sum of values that you can receive by attending events.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= events.length</li>
 *  <li>1 <= k * events.length <= 10^6</li>
 *  <li>1 <= startDayi <= endDayi <= 10^9</li>
 *  <li>1 <= valuei <= 10^6</li>
 * </ul>
 */
public interface MaximumNumberOfEventsThatCanBeAttended2 {

    int maxValue(int[][] events, int k);

    class MaximumNumberOfEventsThatCanBeAttended2Rev1 implements MaximumNumberOfEventsThatCanBeAttended2 {

        @Override
        public int maxValue(int[][] events, int k) {
            int n = events.length;

            // DP top-down
            Integer[][] dp = new Integer[n][k + 1];
            Arrays.sort(events, Comparator.comparingInt(event -> event[0]));
            return calculate(events, 0, k, dp);
        }

        private int calculate(int[][] events, int i, int k, Integer[][] dp) {
            int n = events.length;

            if (i >= n) {
                return 0;
            }

            if (k == 0) {
                return 0;
            }

            // already solved?
            if (dp[i][k] != null) {
                return dp[i][k];
            }

            // option #1: skip events[i]
            int best = calculate(events, i + 1, k, dp);

            // option #2: take events[i], then find the next available event using binary search:
            // next's event start day is the minimum number that is > current's event end day
            // FF..FTT..T
            //      ^ answer (lower boundary)
            int j = nextAvailableEvent(events, i, events[i][1]);
            best = Math.max(best, events[i][2] + calculate(events, j, k - 1, dp));

            // cache and return the answer
            return dp[i][k] = best;
        }

        private int nextAvailableEvent(int[][] events, int left, int target) {
            int right = events.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > target) {
                    // mid might be the answer;
                    // check if there is a better alternative to the left of `mid` index
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
