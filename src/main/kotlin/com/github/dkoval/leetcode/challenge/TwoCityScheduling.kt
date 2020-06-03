package com.github.dkoval.leetcode.challenge

/**
 * [Two City Scheduling](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/)
 *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
object TwoCityScheduling {

    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        // sort costs array by cost difference between cities A and B
        costs.sortBy { (a, b) -> a - b }
        var minTotalCost = 0
        for (i in costs.indices) {
            // send 1st half to city A, 2nd half to city B
            minTotalCost += if (i < costs.size / 2) costs[i][0] else costs[i][1]
        }
        return minTotalCost
    }
}