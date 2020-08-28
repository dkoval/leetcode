package com.github.dkoval.leetcode.challenge

/**
 * [Non-overlapping Intervals](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/)
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 */
object NonOverlappingIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size < 2) return 0
        intervals.sortBy { (start, _) -> start }
        var result = 0
        var lastIntervalIdx = 0
        for (i in 1..intervals.lastIndex) {
            val (currIntervalStart, currIntervalEnd) = intervals[i]
            val (_, lastIntervalEnd) = intervals[lastIntervalIdx]
            if (currIntervalStart < lastIntervalEnd) {
                // overlap
                result++
                if (currIntervalEnd < lastIntervalEnd) {
                    lastIntervalIdx = i
                }
            } else {
                lastIntervalIdx = i
            }
        }
        return result
    }
}