package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-total-importance-of-roads/">Maximum Total Importance of Roads</a>
 * <p>
 * You are given an integer n denoting the number of cities in a country. The cities are numbered from 0 to n - 1.
 * <p>
 * You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional
 * road connecting cities ai and bi.
 * <p>
 * You need to assign each city with an integer value from 1 to n, where each value can only be used once.
 * The importance of a road is then defined as the sum of the values of the two cities it connects.
 * <p>
 * Return the maximum total importance of all roads possible after assigning the values optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 5 * 10^4</li>
 *  <li>1 <= roads.length <= 5 * 10^4</li>
 *  <li>roads[i].length == 2</li>
 *  <li>0 <= ai, bi <= n - 1</li>
 *  <li>ai != bi</li>
 *  <li>There are no duplicate roads</li>
 * </ul>
 */
public interface MaximumTotalImportanceOfRoads {

    long maximumImportance(int n, int[][] roads);

    // O(N * logN) time | O(N) space
    class MaximumTotalImportanceOfRoadsRev1 implements MaximumTotalImportanceOfRoads {

        @Override
        public long maximumImportance(int n, int[][] roads) {
            // track how much each city contributes to the total importance
            int[] counts = new int[n];
            for (int[] road : roads) {
                for (int i = 0; i < 2; i++) {
                    counts[road[i]]++;
                }
            }

            // sort counts[] in ASC order to assign a higher number to more important cities
            Arrays.sort(counts);

            long total = 0;
            for (int i = 0; i < n; i++) {
                total += (long) (i + 1) * counts[i];
            }
            return total;
        }
    }
}
