package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/">The K Weakest Rows in a Matrix</a>
 * <p>
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of
 * the k weakest rows in the matrix ordered from the weakest to the strongest.
 * <p>
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j,
 * or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row,
 * that is, always ones may appear first and then zeros.
 */
public class KWeakestRowsInMatrix {

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
