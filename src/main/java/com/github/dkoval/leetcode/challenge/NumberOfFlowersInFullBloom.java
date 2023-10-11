package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * <a href="https://leetcode.com/problems/number-of-flowers-in-full-bloom/">Number of Flowers in Full Bloom</a>
 * <p>
 * You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be
 * in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n,
 * where people[i] is the time that the ith person will arrive to see the flowers.
 * <p>
 * Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom
 * when the ith person arrives.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= flowers.length <= 5 * 10^4</li>
 *  <li>flowers[i].length == 2</li>
 *  <li>1 <= starti <= endi <= 10^9</li>
 *  <li>1 <= people.length <= 5 * 10^4</li>
 *  <li>1 <= people[i] <= 10^9</li>
 * </ul>
 */
public interface NumberOfFlowersInFullBloom {

    int[] fullBloomFlowers(int[][] flowers, int[] people);

    class NumberOfFlowersInFullBloomRev1 implements NumberOfFlowersInFullBloom {

        @Override
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            int n = flowers.length;
            int p = people.length;

            // Hint 1. At any given time t, the number of flowers blooming at time t is equal to the number of flowers that have started blooming minus the number of flowers that have already stopped blooming.
            int[][] times = new int[2][n];
            for (int i = 0; i < n; i++) {
                times[0][i] = flowers[i][0];
                times[1][i] = flowers[i][1];
            }

            Arrays.sort(times[0]);
            Arrays.sort(times[1]);

            int[] ans = new int[p];
            for (int i = 0; i < p; i++) {
                int startedBlooming = find(times[0], people[i], true);
                int stoppedBlooming = find(times[1], people[i], false);
                ans[i] = startedBlooming - stoppedBlooming;
            }
            return ans;
        }

        private int find(int[] nums, int target, boolean inclusive) {
            // given nums sorted in asc order, returns the number of integers satisfying the condition
            // inclusive: x <= target
            // exclusive: x < target
            // T, T, ..., T, F, F, ..., F
            //            ^ answer (upper boundary)
            int left = 0;
            int right = nums.length - 1;
            Predicate<Integer> condition = x -> inclusive ? x <= target : x < target;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (condition.test(nums[mid])) {
                    // mid might be the answer;
                    // check if there's a better option to the right of `mid` index
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return condition.test(nums[left]) ? left + 1 : 0;
        }
    }
}
