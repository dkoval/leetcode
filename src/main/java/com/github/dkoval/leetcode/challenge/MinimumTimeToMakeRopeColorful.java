package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/">Minimum Time to Make Rope Colorful</a>
 * <p>
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
 * <p>
 * Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color,
 * so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful.
 * You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
 * <p>
 * Return the minimum time Bob needs to make the rope colorful.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == colors.length == neededTime.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= neededTime[i] <= 10^4</li>
 *  <li>colors contains only lowercase English letters.</li>
 * </ul>
 */
public interface MinimumTimeToMakeRopeColorful {

    int minCost(String colors, int[] neededTime);

    // O(N) time | O(1) space
    class MinimumTimeToMakeRopeColorfulRev1 implements MinimumTimeToMakeRopeColorful {

        @Override
        public int minCost(String colors, int[] neededTime) {
            int n = colors.length();

            int total = 0;
            int i = 1;
            while (i < n) {
                if (colors.charAt(i) == colors.charAt(i - 1)) {
                    // in a sequence of balloons of the same color, leave the balloon with the maximum neededTime and
                    // remove the remaining ones; this logic will guarantee that the total time is minimized.
                    int sum = neededTime[i - 1];
                    int max = neededTime[i - 1];
                    while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                        sum += neededTime[i];
                        max = Math.max(max, neededTime[i]);
                        i++;
                    }
                    total += sum - max;
                } else {
                    i++;
                }
            }
            return total;
        }
    }

    // O(N) time | O(1) space
    class MinimumTimeToMakeRopeColorfulRev2 implements MinimumTimeToMakeRopeColorful {

        @Override
        public int minCost(String colors, int[] neededTime) {
            int n = colors.length();

            int cost = 0;
            int last = 0;
            for (int i = 1; i < n; i++) {
                if (colors.charAt(i) == colors.charAt(last)) {
                    if (neededTime[i] < neededTime[last]) {
                        // remove the current balloon
                        cost += neededTime[i];
                    } else {
                        // remove the last balloon
                        cost += neededTime[last];
                        last = i;
                    }
                } else {
                    last = i;
                }
            }
            return cost;
        }
    }
}
