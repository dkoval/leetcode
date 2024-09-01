package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/convert-1d-array-into-2d-array/">Convert 1D Array Into 2D Array</a>
 * <p>
 * You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
 * You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
 * <p>
 * The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
 * the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
 * <p>
 * Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= original.length <= 5 * 10^4</li>
 *  <li>1 <= original[i] <= 10^5</li>
 *  <li>1 <= m, n <= 4 * 10^4</li>
 * </ul>
 */
public interface Convert1DArrayInto2DArray {

    int[][] construct2DArray(int[] original, int m, int n);

    // O(M * N) time | O(1) extra space
    class Convert1DArrayInto2DArrayRev1 implements Convert1DArrayInto2DArray {

        @Override
        public int[][] construct2DArray(int[] original, int m, int n) {
            if (original.length != m * n) {
                return new int[0][0];
            }

            int[][] ans = new int[m][n];
            for (int i = 0; i < original.length; i++) {
                ans[i / n][i % n] = original[i];
            }
            return ans;
        }
    }
}
