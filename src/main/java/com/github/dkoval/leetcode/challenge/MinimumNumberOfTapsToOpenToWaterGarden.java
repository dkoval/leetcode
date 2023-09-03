package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/">Minimum Number of Taps to Open to Water a Garden (Hard)</a>
 * <p>
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e., the length of the garden is n).
 * <p>
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * <p>
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * <p>
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^4</li>
 *  <li>ranges.length == n + 1</li>
 *  <li>0 <= ranges[i] <= 100</li>
 * </ul>
 */
public interface MinimumNumberOfTapsToOpenToWaterGarden {

    int minTaps(int n, int[] ranges);

    // O(N) time | O(N) space
    class MinimumNumberOfTapsToOpenToWaterGardenRev1 implements MinimumNumberOfTapsToOpenToWaterGarden {

        @Override
        public int minTaps(int n, int[] ranges) {
            // idea: greedy
            // r - 1 = n
            int r = ranges.length;

            // farthest[i] is the farthest point reachable from i (going right)
            int[] farthest = new int[r];
            for (int i = 0; i < r; i++) {
                farthest[i] = i;
            }

            for (int i = 0; i < r; i++) {
                int start = Math.max(i - ranges[i], 0);
                int end = Math.min(i + ranges[i], n);
                farthest[start] = Math.max(farthest[start], end);
            }

            int currFarthest = 0; // point to be covered
            int nextFarthest = currFarthest;
            int taps = 0;
            for (int i = 0; i < r - 1; i++) {
                // go as far as possible to cover currFarthest point
                nextFarthest = Math.max(nextFarthest, farthest[i]);
                if (i == currFarthest) {
                    if (nextFarthest == currFarthest) {
                        // no solution
                        return -1;
                    }
                    currFarthest = nextFarthest;
                    taps++;
                }
            }
            return taps;
        }
    }
}
