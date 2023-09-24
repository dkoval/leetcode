package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/champagne-tower/">Champagne Tower</a>
 * <p>
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.
 * Each glass holds one cup of champagne.
 * <p>
 * Then, some champagne is poured into the first glass at the top. When the topmost glass is full,
 * any excess liquid poured will fall equally to the glass immediately to the left and right of it.
 * When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.
 * (A glass at the bottom row has its excess champagne fall on the floor.)
 * <p>
 * For example, after one cup of champagne is poured, the top most glass is full. After two cups of champagne are poured,
 * the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full -
 * there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full,
 * and the two outside glasses are a quarter full, as pictured below.
 * <p>
 * <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/09/tower.png">
 * <p>
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is
 * (both i and j are 0-indexed.)
 * <p>
 * Constraints:
 * </ul>
 *  <li>0 <= poured <= 10^9</li>
 *  <li>0 <= query_glass <= query_row < 100</li>
 * </ul>
 */
public interface ChampagneTower {

    double champagneTower(int poured, int queryRow, int queryGlass);

    class ChampagneTowerRev1 implements ChampagneTower {

        @Override
        public double champagneTower(int poured, int queryRow, int queryGlass) {
            // extra row and column simulate floor, because it's still possible that
            // the liquid pours out of the glasses at the last row
            double[][] glasses = new double[100 + 1][100 + 1];
            glasses[0][0] = poured;
            for (int row = 0; row <= queryRow; row++) {
                for (int col = 0; col <= row; col++) {
                    if (glasses[row][col] > 1.0) {
                        double overflow = (glasses[row][col] - 1.0) / 2;
                        glasses[row][col] = 1.0;
                        glasses[row + 1][col] += overflow;
                        glasses[row + 1][col + 1] += overflow;
                    }
                    if (row == queryRow && col == queryGlass) {
                        return glasses[row][col];
                    }
                }
            }
            return Math.min(glasses[queryRow][queryGlass], 1.0);
        }
    }

    class ChampagneTowerRev2 implements ChampagneTower {

        @Override
        public double champagneTower(int poured, int queryRow, int queryGlass) {
            // a row of glasses in question
            double[] glasses = new double[queryRow + 1];
            glasses[0] = poured;
            for (int i = 1; i <= queryRow; i++) {
                // process (i + 1) glasses in the current row
                for (int j = i; j > 0; j--) {
                    if (glasses[j - 1] > 1.0) {
                        // champagne from the (j - 1)-th glass of the previous row
                        // pours to the j-th and (j - 1)-th glasses of the current row
                        double half = (glasses[j - 1] - 1.0) / 2;
                        glasses[j] += half;
                        glasses[j - 1] = half;
                    } else {
                        glasses[j - 1] = 0.0;
                    }
                }
            }
            return Math.min(glasses[queryGlass], 1.0);
        }
    }
}
