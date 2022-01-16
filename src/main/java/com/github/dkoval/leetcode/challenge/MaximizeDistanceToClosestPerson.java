package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3512/">Maximize Distance to Closest Person</a>
 * <p>
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
 * and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to the closest person.
 */
public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDist = 0;

        // leading empty seats
        int i = 0;
        int numEmptySeats = 0;
        while (i < n && seats[i] == 0) {
            numEmptySeats++;
            i++;
        }

        maxDist = Math.max(maxDist, numEmptySeats);

        // tailing empty seats
        int j = n - 1;
        numEmptySeats = 0;
        while (j >= 0 && seats[j] == 0) {
            numEmptySeats++;
            j--;
        }
        
        maxDist = Math.max(maxDist, numEmptySeats);

        // empty seats in the middle
        numEmptySeats = 0;
        while (i++ < j) {
            if (seats[i] == 0) {
                numEmptySeats++;
            } else {
                maxDist = Math.max(maxDist, (numEmptySeats + 1) / 2);
                numEmptySeats = 0;
            }
        }
        return maxDist;
    }
}
