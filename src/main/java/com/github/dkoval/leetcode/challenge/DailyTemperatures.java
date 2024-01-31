package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= temperatures.length <= 10^5</li>
 *  <li>30 <= temperatures[i] <= 100</li>
 * </ul>
 */
public interface DailyTemperatures {

    int[] dailyTemperatures(int[] temperatures);

    // O(N) time | O(N) space
    class DailyTemperaturesRev1 implements DailyTemperatures {

        @Override
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;

            int[] ans = new int[n];
            Deque<IndexedValue> stack = new ArrayDeque<>();
            stack.push(new IndexedValue(0, temperatures[0]));
            for (int i = 1; i < n; i++) {
                // pop all previous temperatures that are < current temperatures[i]
                while (!stack.isEmpty() && temperatures[i] > stack.peek().value) {
                    IndexedValue prev = stack.pop();
                    ans[prev.index] = i - prev.index;
                }
                stack.push(new IndexedValue(i, temperatures[i]));
            }
            return ans;
        }

        private static class IndexedValue {
            final int index;
            final int value;

            IndexedValue(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }
}
