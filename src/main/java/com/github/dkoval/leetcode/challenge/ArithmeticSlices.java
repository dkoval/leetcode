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
        if (A.length < 3) {
            return 0;
        }
        int numSlices = 0;
        int i = 0;
        int prevDiff = A[1] - A[0];
        for (int j = 2; j < A.length; j++) {
            int currDiff = A[j] - A[j - 1];
            if (currDiff != prevDiff) {
                // start new sequence
                i = j - 1;
                prevDiff = currDiff;
            } else {
                // expand current sequence
                numSlices += j - i - 1;
            }
        }
        return numSlices;
    }
}
