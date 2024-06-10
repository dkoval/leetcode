package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/height-checker/">Height Checker</a>
 * <p>
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line
 * in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * <p>
 * You are given an integer array heights representing the current order that the students are standing in.
 * Each heights[i] is the height of the ith student in line (0-indexed).
 * <p>
 * Return the number of indices where heights[i] != expected[i].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= heights.length <= 100</li>
 *  <li>1 <= heights[i] <= 100</li>
 * </ul>
 */
public interface HeightChecker {

    int heightChecker(int[] heights);

    // O(N * logN) time | O(N) space
    class HeightCheckerRev1 implements HeightChecker {

        @Override
        public int heightChecker(int[] heights) {
            int n = heights.length;

            int[] expected = Arrays.copyOf(heights, n);
            Arrays.sort(expected);

            int mismatches = 0;
            for (int i = 0; i < n; i++) {
                if (expected[i] != heights[i]) {
                    mismatches++;
                }
            }
            return mismatches;
        }
    }
}
