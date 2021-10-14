package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/best-sightseeing-pair/">Best Sightseeing Pair</a>
 * <p>
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
 * Two sightseeing spots i and j have a distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= values.length <= 5 * 10^4</li>
 *  <li>1 <= values[i] <= 1000</li>
 * </ul>
 */
public interface BestSightseeingPair {

    int maxScoreSightseeingPair(int[] values);

    // O(N) time | O(N) space
    class BestSightseeingPairDPBottomUp implements BestSightseeingPair {

        public int maxScoreSightseeingPair(int[] values) {
            int n = values.length;

            // by definition, score = values[i] + values[j] + i - j
            // let's split values[] into 2 parts xs[] and ys[], where
            // xs[i] = values[i] + i, which is a non-decreasing array
            // ys[i] = values[i] - i, which is a non-increasing array
            // maxScore = xs[i] + ys[j] IFF xs[i] is the maximum value in xs[], i < j
            int[] xs = new int[n];
            int[] ys = new int[n];
            for (int i = 0; i < n; i++) {
                xs[i] = values[i] + i;
                ys[i] = values[i] - i;
            }

            int maxScore = 0;
            int maxX = xs[0];
            for (int i = 1; i < n; i++) {
                maxScore = Math.max(maxScore, maxX + ys[i]);
                maxX = Math.max(maxX, xs[i]);
            }
            return maxScore;
        }
    }

    // O(N) time | O(1) space
    class BestSightseeingPairDPBottomUpInConstantSpace implements BestSightseeingPair {

        @Override
        public int maxScoreSightseeingPair(int[] values) {
            int n = values.length;
            int maxScore = 0;
            int max1 = values[0];
            for (int i = 1; i < n; i++) {
                maxScore = Math.max(maxScore, max1 + values[i] - i);
                max1 = Math.max(max1, values[i] + i);
            }
            return maxScore;
        }
    }
}
