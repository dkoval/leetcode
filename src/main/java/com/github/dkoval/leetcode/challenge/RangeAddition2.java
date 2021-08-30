package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/">Range Addition II</a>
 * <p>
 * You are given an m x n matrix M initialized with all 0's and an array of operations ops,
 * where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
 * <p>
 * Count and return the number of maximum integers in the matrix after performing all the operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= m, n <= 4 * 10^4</li>
 *  <li>0 <= ops.length <= 10^4</li>
 *  <li>ops[i].length == 2</li>
 *  <li>1 <= ai <= m</li>
 *  <li>1 <= bi <= n</li>
 * </ul>
 */
public class RangeAddition2 {

    // O(L), where L = length of ops[] | O(1) space
    public int maxCount(int m, int n, int[][] ops) {
        int minHeight = m;
        int minWidth = n;

        // find the common area of intersecting rectangles, i.e.
        // a rectangle with (0, 0) top-left and (min height, min width) bottom-right corners respectively
        for (int[] op : ops) {
            minHeight = Math.min(minHeight, op[0]);
            minWidth = Math.min(minWidth, op[1]);
        }
        return minHeight * minWidth;
    }
}
