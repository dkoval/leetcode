package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-pivot-integer/"> Find the Pivot Integer</a>
 * <p>
 * Given a positive integer n, find the pivot integer x such that:
 * <p>
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 * <p>
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public interface FindPivotInteger {

    int pivotInteger(int n);

    class FindPivotIntegerRev1 implements FindPivotInteger {

        @Override
        public int pivotInteger(int n) {
            int[] prefixSum = new int[n + 1];
            for (int x = 1; x <= n; x++) {
                prefixSum[x] = prefixSum[x - 1] + x;
            }

            for (int x = 1; x <= n; x++) {
                if (prefixSum[x] == prefixSum[n] - prefixSum[x - 1]) {
                    return x;
                }
            }
            return -1;
        }
    }
}
