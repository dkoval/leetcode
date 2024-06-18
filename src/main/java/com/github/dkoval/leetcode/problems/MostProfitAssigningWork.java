package com.github.dkoval.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/most-profit-assigning-work/">Most Profit Assigning Work</a>
 * <p>
 * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
 * <p>
 * difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
 * worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * <p>
 * For example, if three workers attempt the same job that pays $1, then the total profit will be $3.
 * If a worker cannot complete any job, their profit is $0.
 * Return the maximum profit we can achieve after assigning the workers to the jobs.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == difficulty.length</li>
 *  <li>n == profit.length</li>
 *  <li>m == worker.length</li>
 *  <li>1 <= n, m <= 10^4</li>
 *  <li>1 <= difficulty[i], profit[i], worker[i] <= 10^5</li>
 * </ul>
 */
public interface MostProfitAssigningWork {

    int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker);

    class MostProfitAssigningWorkUsingSortingByDifficulty implements MostProfitAssigningWork {

        @Override
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;

            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job(difficulty[i], profit[i]);
            }

            // sort both arrays by difficulty
            Arrays.sort(jobs, Comparator.comparingInt(it -> it.difficulty));
            Arrays.sort(worker);

            int i = 0;
            int total = 0;
            int maxProfitSoFar = 0;
            for (int skill : worker) {
                // Take the most profitable job among those the i-th worker can complete.
                // N.B. One job can be completed multiple times.
                while (i < n && skill >= jobs[i].difficulty) {
                    maxProfitSoFar = Math.max(maxProfitSoFar, jobs[i].profit);
                    i++;
                }
                total += maxProfitSoFar;
            }
            return total;
        }

        private record Job(int difficulty, int profit) {
        }
    }
}
