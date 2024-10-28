package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-square-streak-in-an-array/">Longest Square Streak in an Array</a>
 * <p>
 * You are given an integer array nums. A subsequence of nums is called a square streak if:
 * <ul>
 *  <li>The length of the subsequence is at least 2, and</li>
 *  <li>after sorting the subsequence, each element (except the first element) is the square of the previous number.</li>
 * </ul>
 * Return the length of the longest square streak in nums, or return -1 if there is no square streak.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^5</li>
 *  <li>2 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface LongestSquareStreakInArray {

    int longestSquareStreak(int[] nums);

    class LongestSquareStreakInArrayRev1 implements LongestSquareStreakInArray {

        @Override
        public int longestSquareStreak(int[] nums) {
            Set<Integer> uniq = new HashSet<>();
            for (int x : nums) {
                uniq.add(x);
            }

            // find the starting point of the longest square streak
            int best = 0;
            for (int x : uniq) {
                int sqrt = (int) Math.sqrt(x);
                if (sqrt * sqrt == x && uniq.contains(sqrt)) {
                    // sqrt(x) exists in the set, no reason to start a streak at x;
                    // try to find a smaller start of a square streak
                    continue;
                }

                // 2 <= nums[i] <= 10^5
                int streak = 1;
                int last = x; // the last number in a square streak
                while (last < 1000 && uniq.contains(last * last)) {
                    streak++;
                    last *= last;
                }
                best = Math.max(best, streak);
            }
            return (best > 1) ? best : -1;
        }
    }

    class LongestSquareStreakInArrayRev2 implements LongestSquareStreakInArray {

        @Override
        public int longestSquareStreak(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);

            int best = 0;
            // dp[x] - the length of the longest square streak that starts at x
            Map<Integer, Integer> dp = new HashMap<>();
            for (int i = n - 1; i >= 0; i--) {
                if (dp.containsKey(nums[i] * nums[i])) {
                    // prepend x = nums[i] to the exising square streak, effectively extending the streak by 1
                    // dp[x] = dp[x * x] + 1
                    dp.put(nums[i], dp.get(nums[i] * nums[i]) + 1);
                } else {
                    dp.put(nums[i], 1);
                }
                best = Math.max(best, dp.get(nums[i]));
            }
            return (best > 1) ? best : -1;
        }
    }
}
