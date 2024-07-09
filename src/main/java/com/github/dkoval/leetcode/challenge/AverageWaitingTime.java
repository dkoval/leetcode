package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/average-waiting-time/">Average Waiting Time</a>
 * <p>
 * There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:
 * <ul>
 *  <li>arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.</li>
 *  <li>timei is the time needed to prepare the order of the ith customer.</li>
 * </ul>
 * When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle.
 * The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time.
 * The chef prepares food for customers in the order they were given in the input.
 * <p>
 * Return the average waiting time of all customers. Solutions within 10^-5 from the actual answer are considered accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= customers.length <= 10^5</li>
 *  <li>1 <= arrivali, timei <= 10^4</li>
 *  <li>arrivali <= arrivali+1</li>
 * </ul>
 */
public interface AverageWaitingTime {

    double averageWaitingTime(int[][] customers);

    class AverageWaitingTimeRev1 implements AverageWaitingTime {

        @Override
        public double averageWaitingTime(int[][] customers) {
            int n = customers.length;

            long totalTime = 0;
            int finishedAt = 0;
            for (int[] customer : customers) {
                // take the order of the i-th customer
                finishedAt = Math.max(finishedAt, customer[0]) + customer[1];
                // add waiting time of the i-th customer
                totalTime += finishedAt - customer[0];
            }
            return (double) totalTime / n;
        }
    }
}
