package com.github.dkoval.leetcode.challenge

object InsertIntervalRev2 : InsertInterval {

    // Time complexity: O(N), space complexity: O(1)
    // Resource: https://www.youtube.com/watch?v=FuLfL_WhUHI
    override fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
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