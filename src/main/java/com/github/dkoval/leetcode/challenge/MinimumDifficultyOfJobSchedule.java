package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">Minimum Difficulty of a Job Schedule (Hard)</a>
 * <p>
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * <p>
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days.
 * The difficulty of a day is the maximum difficulty of a job done on that day.
 * <p>
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * <p>
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= jobDifficulty.length <= 300</li>
 *  <li>0 <= jobDifficulty[i] <= 1000</li>
 *  <li>1 <= d <= 10</li>
 * </ul>
 */
public interface MinimumDifficultyOfJobSchedule {

    int minDifficulty(int[] jobDifficulty, int d);

    class MinimumDifficultyOfJobScheduleRev1 implements MinimumDifficultyOfJobSchedule {

        @Override
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;

            int res = calc(jobDifficulty, 0, d, new Integer[n + 1][d + 1]);
            if (res < Integer.MAX_VALUE) {
                return res;
            }
            return -1;
        }

        private int calc(int[] jobDifficulty, int start, int d, Integer[][] dp) {
            int n = jobDifficulty.length;

            if (start == n && d == 0) {
                return 0;
            }

            if (start == n || d == 0) {
                return Integer.MAX_VALUE;
            }

            // already solved?
            if (dp[start][d] != null) {
                return dp[start][d];
            }

            int best = Integer.MAX_VALUE;
            int mostDifficultJobSoFar = 0;
            for (int i = start; i < n; i++) {
                // finish i-th job on the current day
                mostDifficultJobSoFar = Math.max(mostDifficultJobSoFar, jobDifficulty[i]);
                // then proceed to the next day
                int res = calc(jobDifficulty, i + 1, d - 1, dp);
                if (res < Integer.MAX_VALUE) {
                    res += mostDifficultJobSoFar;
                }
                best = Math.min(best, res);
            }
            return dp[start][d] = best;
        }
    }
}
