package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">Minimum Number of Operations to Move All Balls to Each Box</a>
 * <p>
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty,
 * and '1' if it contains one ball.
 * <p>
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
 * Note that after doing so, there may be more than one ball in some boxes.
 * <p>
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls
 * to the ith box.
 * <p>
 * Each answer[i] is calculated considering the initial state of the boxes.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == boxes.length</li>
 *  <li>1 <= n <= 2000</li>
 *  <li>boxes[i] is either '0' or '1'.</li>
 * </ul>
 */
public interface MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    int[] minOperations(String boxes);

    // O(N^2) time | O(1) space
    class MinimumNumberOfOperationsToMoveAllBallsToEachBoxRev1 implements MinimumNumberOfOperationsToMoveAllBallsToEachBox {

        @Override
        public int[] minOperations(String boxes) {
            final var n = boxes.length();

            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                for (var j = 0; j < n; j++) {
                    if (boxes.charAt(j) == '1') {
                        ans[i] += Math.abs(i - j);
                    }
                }
            }
            return ans;
        }
    }
}
