package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3950/">Maximum Profit in Job Scheduling</a>
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
public class MaximumProfitInJobScheduling {

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

    // O(N * logN) time | O(N) space
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // sort jobs by their starting time
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
}
