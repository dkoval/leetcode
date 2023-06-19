package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-highest-altitude/">Find the Highest Altitude</a>
 * <p>
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.
 * <p>
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n).
 * Return the highest altitude of a point.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == gain.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>-100 <= gain[i] <= 100</li>
 * </ul>
 */
public interface FindHighestAltitude {

    int largestAltitude(int[] gain);

    // O(N) time | O(1) space
    class FindHighestAltitudeRev1 implements FindHighestAltitude {

        @Override
        public int largestAltitude(int[] gain) {
            int n = gain.length;

            int best = 0;
            int curr = 0;
            for (int delta : gain) {
                curr += delta;
                best = Math.max(best, curr);
            }
            return best;
        }
    }
}
