package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/">Minimum Number of Moves to Seat Everyone</a>
 * <p>
 * There are n seats and n students in a room. You are given an array seats of length n, where seats[i]
 * is the position of the ith seat. You are also given the array students of length n, where students[j]
 * is the position of the jth student.
 * <p>
 * You may perform the following move any number of times:
 * <p>
 * Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
 * Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.
 * <p>
 * Note that there may be multiple seats or students in the same position at the beginning.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == seats.length == students.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= seats[i], students[j] <= 100</li>
 * </ul>
 */
public interface MinimumNumberOfMovesToSeatEveryone {

    int minMovesToSeat(int[] seats, int[] students);

    // O(N * logN) time | O(1) space
    class MinimumNumberOfMovesToSeatEveryoneRev1 implements MinimumNumberOfMovesToSeatEveryone {

        @Override
        public int minMovesToSeat(int[] seats, int[] students) {
            int n = seats.length;

            Arrays.sort(seats);
            Arrays.sort(students);

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.abs(seats[i] - students[i]);
            }
            return ans;
        }
    }
}
