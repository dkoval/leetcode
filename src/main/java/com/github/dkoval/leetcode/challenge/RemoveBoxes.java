package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3889/">Remove Boxes</a>
 * <p>
 * You are given several boxes with different colors represented by different positive numbers.
 * <p>
 * You may experience several rounds to remove boxes until there is no box left.
 * Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1),
 * remove them and get k * k points.
 * <p>
 * Return the maximum points you can get.
 */
public class RemoveBoxes {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // memo[l][r][k] is the maximum points we can get using l..r boxes
        // with k boxes colored as boxes[r] appended at the end
        int[][][] memo = new int[n][n][n];
        return removeBoxesRecursive(boxes, 0, n - 1, 0, memo);
    }

    private int removeBoxesRecursive(int[] boxes, int l, int r, int k, int[][][] memo) {
        if (l > r) {
            return 0;
        }

        if (memo[l][r][k] > 0) {
            return memo[l][r][k];
        }

        // Remove (k + 1) boxes of the same color, including boxes[r], and gain (k + 1)^2 points.
        memo[l][r][k] = removeBoxesRecursive(boxes, l, r - 1, 0, memo) + (k + 1) * (k + 1);

        // Among all boxes[i] == boxes[r] find the best solution for all i = l..r - 1
        for (int i = l; i < r; i++) {
            // Partition boxes[l:r] subarray into two:
            // #1: [boxes[i + 1], ..., boxes[r - 1]] - there are 0 boxes colored as boxes[r - 1] to the right of (r - 1)-st box
            // #2: [boxes[l], ..., boxes[i] = A, boxes[r] = A, A, A...A] - there are (k + 1) boxes colored as boxes[i] = boxes[r] = A to the right of i-th box
            if (boxes[i] == boxes[r]) {
                memo[l][r][k] = Math.max(
                        memo[l][r][k],
                        removeBoxesRecursive(boxes, i + 1, r - 1, 0, memo) + removeBoxesRecursive(boxes, l, i, k + 1, memo));
            }
        }
        return memo[l][r][k];
    }
}
