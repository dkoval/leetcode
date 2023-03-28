package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">Minimum Cost For Tickets</a>
 * <p>
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days.
 * Each day is an integer from 1 to 365.
 * <p>
 * Train tickets are sold in three different ways:
 * <ul>
 *  <li>a 1-day pass is sold for costs[0] dollars,</li>
 *  <li>a 7-day pass is sold for costs[1] dollars, and</li>
 *  <li>a 30-day pass is sold for costs[2] dollars.</li>
 * </ul>
 * The passes allow that many days of consecutive travel.
 * <p>
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * <p>
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= days.length <= 365</li>
 *  <li>1 <= days[i] <= 365</li>
 *  <li>days is in strictly increasing order.</li>
 *  <li>costs.length == 3</li>
 *  <li>1 <= costs[i] <= 1000</li>
 * </ul>
 */
public interface MinimumCostForTickets {

    int mincostTickets(int[] days, int[] costs);

    class MinimumCostForTicketsDPTopDown implements MinimumCostForTickets {

        @Override
        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;

            int[] durations = {1, 7, 30};
            Ticket[] tickets = new Ticket[3];
            for (int i = 0; i < 3; i++) {
                tickets[i] = new Ticket(durations[i], costs[i]);
            }

            Integer[][] memo = new Integer[n + 1][365 + 1];
            return minCost(days, 0, 0, tickets, memo);
        }

        private int minCost(int[] days, int idx, int validTill, Ticket[] tickets, Integer[][] memo) {
            if (idx >= days.length) {
                return 0;
            }

            // already solved?
            if (memo[idx][validTill] != null) {
                return memo[idx][validTill];
            }

            // option #1: if the owned ticket is still valid, skip days[i]
            if (days[idx] <= validTill) {
                return minCost(days, idx + 1, validTill, tickets, memo);
            }

            // option #2: buy a ticket on days[i]
            int best = Integer.MAX_VALUE;
            for (Ticket ticket : tickets) {
                best = Math.min(best,
                        ticket.cost + minCost(days, idx + 1, Math.min(days[idx] + ticket.duration - 1, 365), tickets, memo));
            }
            return memo[idx][validTill] = best;
        }

        private static class Ticket {
            final int duration;
            final int cost;

            Ticket(int duration, int cost) {
                this.duration = duration;
                this.cost = cost;
            }
        }
    }
}
