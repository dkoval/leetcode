package com.github.dkoval.leetcode.challenge

/**
 * [Find Right Interval](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/)
 *
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger
 * than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum
 * start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 * - You may assume the interval's end point is always bigger than its start point.
 * - You may assume none of these intervals have the same start point.
 */
object FindRightInterval {

    private data class IndexedInterval(val index: Int, val start: Int, val end: Int)

    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val sortedIntervals = intervals
            .mapIndexed { index, (start, end) -> IndexedInterval(index, start, end) }
            .sortedBy { it.start }

        val result = IntArray(intervals.size)
        for (i in intervals.indices) {
            val end = intervals[i][1]
            result[i] = findRightIntervalIndex(sortedIntervals, end)
        }
        return result
    }

    private fun findRightIntervalIndex(sortedIntervals: List<IndexedInterval>, target: Int): Int {
        if (sortedIntervals.last().start < target) return -1
        // binary search
        var l = 0
        var r = sortedIntervals.lastIndex
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (sortedIntervals[mid].start >= target) r = mid - 1
            else l = mid + 1
        }
        return sortedIntervals[l].index
    }
}