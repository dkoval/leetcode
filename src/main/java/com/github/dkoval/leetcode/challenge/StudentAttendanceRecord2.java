package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/student-attendance-record-ii/">Student Attendance Record II</a>
 * <p>
 * An attendance record for a student can be represented as a string where each character signifies whether
 * the student was absent, late, or present on that day. The record only contains the following three characters:
 * <ul>
 *  <li>'A': Absent.</li>
 *  <li>'L': Late.</li>
 *  <li>'P': Present.</li>
 * </ul>
 * Any student is eligible for an attendance award if they meet both of the following criteria:
 * <ul>
 *  <li>The student was absent ('A') for strictly fewer than 2 days total.</li>
 *  <li>The student was never late ('L') for 3 or more consecutive days.</li>
 * </ul>
 * Given an integer n, return the number of possible attendance records of length n that make a student eligible for
 * an attendance award. The answer may be very large, so return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public interface StudentAttendanceRecord2 {

    int MOD = 1_000_000_007;

    int checkRecord(int n);

    class StudentAttendanceRecord2DPTopDown implements StudentAttendanceRecord2 {

        @Override
        public int checkRecord(int n) {
            // idea: smart bruteforce with DP top-down
            return calc(n, 0, 0, new Integer[n + 1][2][3]);
        }

        // n -> 0 .. N
        // daysAbsent -> 0 .. 1
        // daysLate -> 0 .. 2
        private int calc(int n, int daysAbsent, int daysLate, Integer[][][] dp) {
            if (n == 0) {
                return 1;
            }

            // already solved?
            if (dp[n][daysAbsent][daysLate] != null) {
                return dp[n][daysAbsent][daysLate];
            }

            // NB: "L" days must be consecutive, therefore daysLate gets reset
            // when processing "P" and "A" days
            long total = 0;

            // option #1: "P" day
            total += calc(n - 1, daysAbsent, 0, dp);
            total %= MOD;

            // option #2: "A" day
            if (daysAbsent + 1 < 2) {
                total += calc(n - 1, daysAbsent + 1, 0, dp);
                total %= MOD;
            }

            // option #3: "L" day
            if (daysLate + 1 < 3) {
                total += calc(n - 1, daysAbsent, daysLate + 1, dp);
                total %= MOD;
            }

            // cache and return the answer
            return dp[n][daysAbsent][daysLate] = (int) total;
        }
    }
}
