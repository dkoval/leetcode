package com.github.dkoval.leetcode.challenge;

/**
 * <a https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3644/>Arithmetic Slices</a>
 * <p>
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }

        int count = 0;
        int start = 0;
        int prevDiff = A[1] - A[0];
        for (int end = 2; end < n; end++) {
            int currDiff = A[end] - A[end - 1];
            if (currDiff != prevDiff) {
                // start new sequence
                start = end - 1;
                prevDiff = currDiff;
            } else {
                // expand current sequence
                count += end - start - 1;
            }
        }
        return count;
    }
}
