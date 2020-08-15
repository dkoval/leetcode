package com.github.dkoval.leetcode.challenge

/**
 * [Non-overlapping Intervals](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/)
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 */
object NonOverlappingIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortBy { (start, _) -> start }
        var result = 0
        var end = intervals[0][1]
        for (i in 1..intervals.lastIndex) {
            end = if (intervals[i][0] < end) {
                result++
                minOf(intervals[i][1], end) // remove larger interval
            } else {
                intervals[i][1]
            }
        }
        return result
    }
}