package com.github.dkoval.leetcode.challenge

/**
 * [Insert Interval](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3458/)
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 */
object InsertInterval {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)
        val idx = findInsertIndex(intervals, newInterval)
        val result = mutableListOf<IntArray>()
        for (i in 0 until idx) {
            result += intervals[i]
        }
        val copyFrom = when {
            idx == intervals.size || newInterval[1] < intervals[idx][0] -> {
                // no overlap - either append the newInterval
                result += newInterval
                idx
            }
            else -> {
                // merge overlapping intervals
                val start = minOf(newInterval[0], intervals[idx][0])
                var end = newInterval[1]
                // can we further expand the end of the interval?
                var i = idx
                while (i < intervals.size && newInterval[1] >= intervals[i][0]) {
                    end = maxOf(end, intervals[i][1])
                    i++
                }
                result += intArrayOf(start, end)
                if (i != idx) i else idx + 1
            }
        }
        // copy remaining intervals
        for (i in copyFrom until intervals.size) {
            result += intervals[i]
        }
        return result.toTypedArray()
    }

    private fun findInsertIndex(intervals: Array<IntArray>, newInterval: IntArray): Int {
        var i = 0
        while (i < intervals.size && newInterval[0] > intervals[i][1]) {
            i++
        }
        return i
    }
}