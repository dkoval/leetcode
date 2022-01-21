package com.github.dkoval.leetcode.challenge

/**
 * [Gas Station](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3470/)
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is ```gas[i]```.
 *
 * You have a car with an unlimited gas tank and it costs ```cost[i]``` of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 *
 * Note:
 * - If there exists a solution, it is guaranteed to be unique.
 * - Both input arrays are non-empty and have the same length.
 * - Each element in the input arrays is a non-negative integer.
 */
interface GasStation {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int
}

// Time complexity: O(N^2), space complexity: O(1)
object GasStationBruteForce : GasStation {

    override fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        for (start in gas.indices) {
            var i = start
            var gasInTank = 0
            do {
                gasInTank += gas[i] - cost[i]
                if (gasInTank < 0) break
                i = (i + 1) % n
            } while (i != start)
            if (i == start && gasInTank >= 0) {
                return start
            }
        }
        return -1
    }
}

// Time complexity: O(N), space complexity: O(1)
object GasStationGreedy : GasStation {

    // Resource: https://www.youtube.com/watch?v=xWgbFI_rXJs
    override fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var start = 0
        var tank = 0 // amount of gas in the tank
        var sumOfDiffs = 0 // sum of gas[i] - cost[i] differences
        for (i in gas.indices) {
            val diff = gas[i] - cost[i]
            sumOfDiffs += diff
            tank += diff
            if (tank < 0) {
                // we won't be able to get to (i + 1)-th gas station if we start at any index [0:i];
                // therefore, we try to start at (i + 1)-th gas station and see if we manage to complete the route
                start = i + 1
                tank = 0
            }
        }
        return if (sumOfDiffs >= 0) start else -1
    }
}