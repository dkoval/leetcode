package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-hire-k-workers/">Minimum Cost to Hire K Workers (Hard)</a>
 * <p>
 * There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the i-th worker
 * and wage[i] is the minimum wage expectation for the i-th worker.
 * <p>
 * We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according
 * to the following rules:
 * <ol>
 *  <li>Every worker in the paid group must be paid at least their minimum wage expectation.</li>
 *  <li>In the group, each worker's pay must be directly proportional to their quality.
 *  This means if a worker’s quality is double that of another worker in the group,
 *  then they must be paid twice as much as the other worker.</li>
 * </ol>
 * Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions.
 * Answers within 10^-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == quality.length == wage.length</li>
 *  <li>1 <= k <= n <= 10^4</li>
 *  <li>1 <= quality[i], wage[i] <= 10^4</li>
 * </ul>
 */
public interface MinimumCostToHireKWorkers {

    double mincostToHireWorkers(int[] quality, int[] wage, int k);

    // O(N*(logN + logK)) time | O(N) space
    class MinimumCostToHireKWorkersRev1 implements MinimumCostToHireKWorkers {

        @Override
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            // Idea: substitute wage[] with worker rates, where rates[i] = wage[i] / quality[i].
            // If we can hire a worker with the rate r, then we can hire any other workers with their
            // rates <= r.
            int n = quality.length;

            Worker[] workers = new Worker[n];
            for (int i = 0; i < n; i++) {
                workers[i] = new Worker((double) wage[i] / quality[i], quality[i]);
            }

            // Greedy part
            //
            // The amount of money to pay to the i-th worker in a group of k workers is
            // the largest rate in the group * quality[i]
            //
            // The total cost of forming a paid group of k workers is
            // the largest rate in the group * total quality of k workers
            //
            // 1. Sort workers by rate in ASC order.
            // 2. Max heap stores the k largest qualities.
            Arrays.sort(workers, Comparator.comparingDouble(worker -> worker.rate));
            Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

            double best = Double.MAX_VALUE;
            int totalQuality = 0;
            for (Worker worker : workers) {
                totalQuality += worker.quality;
                q.offer(worker.quality);

                if (q.size() > k) {
                    // to minimize the total cost, remove a worker with the largest quality from the group
                    totalQuality -= q.poll();
                }

                if (q.size() == k) {
                    best = Math.min(best, worker.rate * totalQuality);
                }
            }
            return best;
        }

        private record Worker(double rate, int quality) {}
    }
}
