package com.github.dkoval.leetcode.challenge

/**
 * [Insert Interval](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3458/)
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 */
object InsertInterval {

    // Time complexity: O(N), space complexity: O(1)
    // Resource: https://www.youtube.com/watch?v=FuLfL_WhUHI&t=1s
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        // include intervals that occur before `newInterval`
        while (i < intervals.size && intervals[i][1] < newInterval[0]) { // end of the current interval is before `newInterval` start
            result += intervals[i]
            i++
        }
        // include intervals overlapping with `newInterval` and merge them together
        val mergedInterval = newInterval.copyOf()
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) { // start of the current interval is before `newInterval` end
            mergedInterval[0] = minOf(mergedInterval[0], intervals[i][0])
            mergedInterval[1] = maxOf(mergedInterval[1], intervals[i][1])
            i++
        }
        result += mergedInterval
        // include remaining intervals
        while (i < intervals.size) {
            result += intervals[i]
            i++
        }
        return result.toTypedArray()
    }
}