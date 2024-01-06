package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">Maximum Profit in Job Scheduling</a>
 * <p>
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are
 * no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4</li>
 *  <li>1 <= startTime[i] < endTime[i] <= 10^9</li>
 *  <li>1 <= profit[i] <= 10^4</li>
 * </ul>
 */
public interface MaximumProfitInJobScheduling {

    int jobScheduling(int[] startTime, int[] endTime, int[] profit);

    // O(N * logN) time | O(N) space
    class MaximumProfitInJobSchedulingRev1 implements MaximumProfitInJobScheduling {

        @Override
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;

            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            }

            // sort jobs by their ending time
            Arrays.sort(jobs, Comparator.comparingInt(task -> task.endTime));

            // stores maxProfit (value) we can make at the time jobs[i] ends (key);
            // since TreeMap keeps keys sorted, we can binary search on them
            TreeMap<Integer, Integer> maxProfitAt = new TreeMap<>();

            int maxProfit = 0;
            for (Job job : jobs) {
                // max profit we can make before jobs[i] starts
                Map.Entry<Integer, Integer> entry = maxProfitAt.floorEntry(job.startTime);
                int maxProfitAtStartTime = (entry != null) ? entry.getValue() : 0;

                // store max profit we can make at the time jobs[i] ends
                maxProfit = Math.max(maxProfit, maxProfitAtStartTime + job.profit);
                maxProfitAt.put(job.endTime, maxProfit);
            }
            return maxProfit;
        }

        private static class Job {
            final int startTime;
            final int endTime;
            final int profit;

            Job(int startTime, int endTime, int profit) {
                this.startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
        }
    }

    // O(N * logN) time | O(N) space
    class MaximumProfitInJobSchedulingRev2 implements MaximumProfitInJobScheduling {

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;

            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            }

            // sort jobs by the starting time
            Arrays.sort(jobs, Comparator.comparingInt(job -> job.startTime));

            // DP top-down
            return calc(jobs, 0, new Integer[n]);
        }

        private int calc(Job[] jobs, int index, Integer[] dp) {
            // base case
            if (index == jobs.length) {
                return 0;
            }

            // already solved?
            if (dp[index] != null) {
                return dp[index];
            }

            // option #1: skip jobs[index]
            int res1 = calc(jobs, index + 1, dp);

            // option #2: take jobs[index]
            int nextIndex = nextJob(jobs, index);
            int res2 = jobs[index].profit + calc(jobs, nextIndex, dp);

            // cache and return the answer
            return dp[index] = Math.max(res1, res2);
        }

        private int nextJob(Job[] jobs, int index) {
            // find the index of the next job to take, i.e.
            // a job with the lowest startTime >= jobs[index].endTime
            // since jobs[] is sorted by the starting time, binary search can be used here:
            // FF...FTT...T
            //       ^ answer
            int left = index;
            int right = jobs.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (jobs[mid].startTime >= jobs[index].endTime) {
                    // mid might be the answer;
                    // check if there's a better option to the left of it
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private static class Job {
            final int startTime;
            final int endTime;
            final int profit;

            Job(int startTime, int endTime, int profit) {
                this.startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
        }
    }
}
