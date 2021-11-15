package com.github.dkoval.leetcode.challenge

/**
 * [Non-overlapping Intervals](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/)
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 */
object NonOverlappingIntervals {

    // Resource: https://www.youtube.com/watch?v=BW7LeuJIMhE
    // O(N*logN) time | O(1) space
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size < 2) return 0
        intervals.sortBy { (start, _) -> start }

        var count = 0
        var lastIncludedIntervalIdx = 0
        for (i in 1..intervals.lastIndex) {
            val curr = intervals[i] // current interval
            val last = intervals[lastIncludedIntervalIdx] // last included interval
            if (curr[0] < last[1]) {
                // overlap - either `last` or `curr` interval needs to be removed
                count++
                if (curr[1] < last[1]) {
                    // `last` includes `curr`, therefore remove `last` and set new `last` to `curr`;
                    // otherwise simply remove `curr` (`last` remains the same)
                    lastIncludedIntervalIdx = i
                }
            } else {
                // no overlap - include `curr`
                lastIncludedIntervalIdx = i
            }
        }
        return count
    }
}