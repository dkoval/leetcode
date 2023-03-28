package com.github.dkoval.leetcode.challenge

object MinimumCostForTicketsDPBottomUp : MinimumCostForTickets {

    // Time complexity: O(N), space complexity = 0(N)
    override fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val n = days.size

        // DP bottom up
        // dp[i] = minOf(cost of 1-day ticket + dp[i + 1], cost of 7-day ticket + dp[i + 1], cost of 30-day ticket + dp[i + 1])
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[n] = 0

        val ticketValidityPeriodsInDays = intArrayOf(1, 7, 30)
        for (i in n - 1 downTo 0) {
            ticketValidityPeriodsInDays.forEachIndexed { idx, ticketValidityPeriodInDays ->
                var j = i
                while (j < n && days[j] < days[i] + ticketValidityPeriodInDays) j++
                dp[i] = minOf(dp[i], costs[idx] + dp[j])
            }
        }
        return dp[0]
    }
}