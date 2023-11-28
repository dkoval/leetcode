package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/">Number of Ways to Divide a Long Corridor (Hard)</a>
 * <p>
 * Along a long library corridor, there is a line of seats and decorative plants.
 * You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat
 * and each 'P' represents a plant.
 * <p>
 * One room divider has already been installed to the left of index 0, and another to the right of index n - 1.
 * Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1),
 * at most one divider can be installed.
 * <p>
 * Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants.
 * There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider
 * installed in the first way but not in the second way.
 * <p>
 * Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 10^9 + 7.
 * If there is no way, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == corridor.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>corridor[i] is either 'S' or 'P'.</li>
 * </ul>
 */
public interface NumberOfWaysToDivideLongCorridor {

    int MOD = 1_000_000_007;

    int numberOfWays(String corridor);

    class NumberOfWaysToDivideLongCorridorRev1 implements NumberOfWaysToDivideLongCorridor {

        @Override
        public int numberOfWays(String corridor) {
            int n = corridor.length();

            // S...S P...P S...S P...P S...S ...
            // <--->       <--->       <---> segment starts and ends with 'S'
            // Given there are k plants between 2 consecutive segments, we can place (k + 1) dividers.
            // Therefore, ans = (k1 + 1) * (k2 + 1) * (k3 + 1) * ...
            int i = 0;

            // skip leading P's
            while (i < n && corridor.charAt(i) == 'P') {
                i++;
            }

            if (i == n) {
                return 0;
            }

            long ans = 1L;
            boolean segmentStarted = true;
            while (i < n) {
                // corridor[i] == 'S', move to the next symbol (two 'S' are needed to form a segment)
                i++;
                if (segmentStarted) {
                    // find the position where the current segment ends
                    while (i < n && corridor.charAt(i) != 'S') {
                        i++;
                    }

                    if (i < n) {
                        segmentStarted = false;
                    }
                } else {
                    // find the position where the next segment starts
                    int dividers = 0;
                    while (i < n && corridor.charAt(i) != 'S') {
                        i++;
                        dividers++;
                    }

                    if (i < n) {
                        segmentStarted = true;
                        ans *= dividers + 1;
                        ans %= MOD;
                    }
                }
            }
            return segmentStarted ? 0 : (int) ans;
        }
    }

    class NumberOfWaysToDivideLongCorridorRev2 implements NumberOfWaysToDivideLongCorridor {

        @Override
        public int numberOfWays(String corridor) {
            int n = corridor.length();

            long ans = 1L;
            int lastSeat = -1;
            int seats = 0;
            for (int i = 0; i < n; i++) {
                if (corridor.charAt(i) == 'S') {
                    seats++;
                    if (seats % 2 == 0) {
                        // record the index of the seat closing the current segment
                        lastSeat = i;
                    } else if (seats > 1) {
                        ans *= i - lastSeat;
                        ans %= MOD;
                    }
                }
            }
            return (seats >= 2 && seats % 2 == 0) ? (int) ans : 0;
        }
    }
}
