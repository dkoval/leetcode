package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3508/">Champagne Tower</a>
 * <p>
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.
 * Each glass holds one cup (250ml) of champagne.
 * <p>
 * Then, some champagne is poured in the first glass at the top. When the topmost glass is full, any excess liquid poured
 * will fall equally to the glass immediately to the left and right of it. When those glasses become full, any excess
 * champagne will fall equally to the left and right of those glasses, and so on.
 * (A glass at the bottom row has its excess champagne fall on the floor.)
 * <p>
 * For example, after one cup of champagne is poured, the top most glass is full. After two cups of champagne are poured,
 * the two glasses on the second row are half full. After three cups of champagne are poured, those two cups become full -
 * there are 3 full glasses total now. After four cups of champagne are poured, the third row has the middle glass half full,
 * and the two outside glasses are a quarter full, as pictured below.
 * <p>
 * <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/09/tower.png">
 * <p>
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is
 * (both i and j are 0-indexed.)
 */
public class ChampagneTower {

    private static final int NUM_ROWS = 100;

    public double champagneTower(int poured, int query_row, int query_col) {
        // extra row and column simulate floor, because it's still possible that
        // the liquid pours out of the glasses at the last row
        double[][] glasses = new double[NUM_ROWS + 1][NUM_ROWS + 1];
        glasses[0][0] = poured;
        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                if (glasses[row][col] > 1) {
                    double overflow = (glasses[row][col] - 1.0) / 2;
                    glasses[row][col] = 1.0;
                    glasses[row + 1][col] += overflow;
                    glasses[row + 1][col + 1] += overflow;
                }
                if (row == query_row && col == query_col) {
                    return glasses[row][col];
                }
            }
        }
        return Math.min(1, glasses[query_row][query_col]);
    }
}
