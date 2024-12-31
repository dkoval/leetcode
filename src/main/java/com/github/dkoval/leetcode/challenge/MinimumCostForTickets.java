package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

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

    class MinimumCostForTicketsDPTopDownRev1 implements MinimumCostForTickets {

        @Override
        public int mincostTickets(int[] days, int[] costs) {
            final var n = days.length;

            final var durations = new int[]{1, 7, 30};
            final var tickets = new Ticket[3];
            for (var i = 0; i < 3; i++) {
                tickets[i] = new Ticket(durations[i], costs[i]);
            }
            return minCost(days, 0, 0, tickets, new Integer[n + 1][365 + 1]);
        }

        private int minCost(int[] days, int idx, int validTo, Ticket[] tickets, Integer[][] dp) {
            if (idx >= days.length) {
                return 0;
            }

            // already solved?
            if (dp[idx][validTo] != null) {
                return dp[idx][validTo];
            }

            // option #1: if the owned ticket is still valid, skip days[i]
            if (days[idx] <= validTo) {
                return minCost(days, idx + 1, validTo, tickets, dp);
            }

            // option #2: buy a ticket on days[i]
            var best = Integer.MAX_VALUE;
            for (Ticket ticket : tickets) {
                best = Math.min(best,
                        ticket.cost + minCost(days, idx + 1, Math.min(days[idx] + ticket.duration - 1, 365), tickets, dp));
            }
            return dp[idx][validTo] = best;
        }

        private record Ticket(int duration, int cost) {
        }
    }

    class MinimumCostForTicketsDPTopDownRev2 implements MinimumCostForTickets {

        @Override
        public int mincostTickets(int[] days, int[] costs) {
            final var travels = new HashSet<Integer>();
            var maxDay = -1;
            for (var day : days) {
                travels.add(day);
                maxDay = Math.max(maxDay, day);
            }

            return minCost(1, maxDay, travels, new int[]{1, 7, 30}, costs, new Integer[maxDay + 1]);
        }

        private int minCost(int currDay, int maxDay, Set<Integer> travels, int[] durations, int[] costs, Integer[] dp) {
            if (currDay > maxDay) {
                return 0;
            }

            // already solved?
            if (dp[currDay] != null) {
                return dp[currDay];
            }

            if (travels.contains(currDay)) {
                // option #1: travel on this day, hence buy a ticket
                var best = Integer.MAX_VALUE;
                for (var i = 0; i < 3; i++) {
                    best = Math.min(best,
                            costs[i] + minCost(currDay + durations[i], maxDay, travels, durations, costs, dp));
                }
                return dp[currDay] = best;
            }

            // option #2: skip this day
            return dp[currDay] = minCost(currDay + 1, maxDay, travels, durations, costs, dp);
        }
    }
}
