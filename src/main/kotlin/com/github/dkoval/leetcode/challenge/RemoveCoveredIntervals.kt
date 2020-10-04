package com.github.dkoval.leetcode.challenge

/**
 * [Remove Covered Intervals](https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3483/)
 *
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval ```[a,b)``` is covered by interval ```[c,d)``` if and only if ```c <= a``` and ```b <= d```.
 *
 * After doing so, return the number of remaining intervals.
 */
interface RemoveCoveredIntervals {

    fun removeCoveredIntervals(intervals: Array<IntArray>): Int
}

// Time complexity: O(N^2), space complexity: O(1)
object RemoveCoveredIntervalsBruteForceKt : RemoveCoveredIntervals {

    override fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        var numCoveredIntervals = 0
        for (i in intervals.indices) {
            for (j in intervals.indices) {
                if (i == j) continue
                if (intervals[i].isIntervalCoveredBy(intervals[j])) {
                    numCoveredIntervals++
                    break
                }
            }
        }
        return intervals.size - numCoveredIntervals
    }

    private fun IntArray.isIntervalCoveredBy(interval: IntArray): Boolean =
        interval[0] <= this[0] && interval[1] >= this[1]
}