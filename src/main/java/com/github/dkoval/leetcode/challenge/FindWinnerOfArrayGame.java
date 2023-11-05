package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/find-the-winner-of-an-array-game/">Find the Winner of an Array Game</a>
 * <p>
 * Given an integer array arr of distinct integers and an integer k.
 * <p>
 * A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game,
 * we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array.
 * The game ends when an integer wins k consecutive rounds.
 * <p>
 * Return the integer which will win the game.
 * <p>
 * It is guaranteed that there will be a winner of the game.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 10^5</li>
 *  <li>1 <= arr[i] <= 10^6</li>
 *  <li>arr contains distinct integers</li>
 *  <li>1 <= k <= 10^9</li>
 * </ul>
 */
public interface FindWinnerOfArrayGame {

    int getWinner(int[] arr, int k);

    class FindWinnerOfArrayGameRev1 implements FindWinnerOfArrayGame {

        @Override
        public int getWinner(int[] arr, int k) {
            int n = arr.length;
            k = Math.min(k, n);

            Deque<Integer> q = new ArrayDeque<>();
            for (int x : arr) {
                q.offerLast(x);
            }

            int winCount = 0;
            while (winCount < k) {
                int x0 = q.pollFirst();
                int x1 = q.pollFirst();
                if (x0 > x1) {
                    q.offerFirst(x0);
                    q.offerLast(x1);
                    winCount++;
                } else {
                    // arr[] contains distinct integers, tie is not possible
                    q.offerFirst(x1);
                    q.offerLast(x0);
                    winCount = 1;
                }
            }
            return q.peekFirst();
        }
    }
}
