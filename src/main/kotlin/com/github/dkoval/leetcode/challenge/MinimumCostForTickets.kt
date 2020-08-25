package com.github.dkoval.leetcode.challenge

/**
 * [Minimum Cost For Tickets](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3436/)
 *
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 * - a 1-day pass is sold for ```costs[0]``` dollars;
 * - a 7-day pass is sold for ```costs[1]``` dollars;
 * - a 30-day pass is sold for ```costs[2]``` dollars.
 *
 * The passes allow that many days of consecutive travel. For example, if we get a 7-day pass on day 2,
 * then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */
object MinimumCostForTickets {

    // Time complexity: O(N), space complexity = 0(N)
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        // DP bottom up
        // dp[i] = minOf(cost of 1-day ticket + dp[i + 1], cost of 2-days ticket + dp[i + 1], cost of 30-days ticket + dp[i + 1])
        val dp = IntArray(days.size + 1) { Int.MAX_VALUE }
        dp[dp.lastIndex] = 0
        val ticketValidityPeriodsInDays = intArrayOf(1, 7, 30)
        for (i in dp.lastIndex - 1 downTo 0) {
            ticketValidityPeriodsInDays.forEachIndexed { idx, ticketValidityPeriodInDays ->
                var j = i
                while (j < days.size && days[j] < days[i] + ticketValidityPeriodInDays) j++
                dp[i] = minOf(dp[i], costs[idx] + dp[j])
            }
        }
        return dp[0]
    }
}