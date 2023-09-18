package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/">The K Weakest Rows in a Matrix</a>
 * <p>
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <ul>
 *  <li>The number of soldiers in row i is less than the number of soldiers in row j.</li>
 *  <li>Both rows have the same number of soldiers and i < j.</li>
 * </ul>
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>2 <= n, m <= 100</li>
 *  <li>1 <= k <= m</li>
 *  <li>matrix[i][j] is either 0 or 1</li>
 * </ul>
 */
public interface KWeakestRowsInMatrix {

    int[] kWeakestRows(int[][] mat, int k);

    class KWeakestRowsInMatrixBySortingRows implements KWeakestRowsInMatrix {

        @Override
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
            Integer[] rows = new Integer[m];
            for (int i = 0; i < m; i++) {
                rows[i] = i;
            }

            Arrays.sort(rows, new WeakestRowsComparator(mat));
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = rows[i];
            }
            return result;
        }

        private static class WeakestRowsComparator implements Comparator<Integer> {
            final int[][] mat;

            WeakestRowsComparator(int[][] mat) {
                this.mat = mat;
            }

            public int compare(Integer row1, Integer row2) {
                int count1 = countSoldiers(row1);
                int count2 = countSoldiers(row2);
                return (count1 != count2) ? count1 - count2 : row1 - row2;
            }

            private int countSoldiers(int row) {
                int count = 0;
                int col = 0;
                while (col < mat[row].length && mat[row][col++] == 1) {
                    count++;
                }
                return count;
            }
        }
    }

    class KWeakestRowsInMatrixUsingPriorityQueue implements KWeakestRowsInMatrix {

        @Override
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;

            Queue<Integer> maxHeap = new PriorityQueue<>((i, j) -> {
                int ones1 = countOnes(mat[i]);
                int ones2 = countOnes(mat[j]);
                return (ones1 == ones2) ? -1 * Integer.compare(i, j) : -1 * Integer.compare(ones1, ones2);
            });

            for (int i = 0; i < m; i++) {
                maxHeap.offer(i);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            int i = 0;
            int[] ans = new int[k];
            while (!maxHeap.isEmpty()) {
                ans[k - i - 1] = maxHeap.poll();
                i++;
            }
            return ans;
        }

        private int countOnes(int[] row) {
            int count = 0;
            for (int x : row) {
                if (x == 0) {
                    break;
                }
                count++;
            }
            return count;
        }
    }
}
