package com.github.dkoval.leetcode.challenge

/**
 * [Find Right Interval](https://leetcode.com/problems/find-right-interval/)
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
 *
 * Constraints:
 * - ```1 <= intervals.length <= 2 * 10^4```
 * - ```intervals[i].length == 2```
 * - ```-10^6 <= start_i <= endi <= 10^6```
The start point of each interval is unique.
 */
object FindRightInterval {

    private data class IndexedInterval(
        val index: Int,
        val start: Int,
        val end: Int
    )

    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        // sort intervals by their starting point + record the original index
        val sortedIntervals = intervals
            .mapIndexed { index, (start, end) -> IndexedInterval(index, start, end) }
            .sortedBy { it.start }

        val result = IntArray(intervals.size)
        for (i in intervals.indices) {
            result[i] = findRightIntervalIndex(sortedIntervals, intervals[i][1])
        }
        return result
    }

    private fun findRightIntervalIndex(sortedIntervals: List<IndexedInterval>, end: Int): Int {
        // use binary search to find the leftmost interval for which
        // its starting point > than the current interval's ending point
        // FF...FTT...T
        //       ^ answer
        var l = 0
        var r = sortedIntervals.lastIndex
        var index = -1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (sortedIntervals[mid].start >= end) {
                // mid might be the answer;
                // check if there is a better option to the left of index mid
                index = sortedIntervals[mid].index
                r = mid - 1
            } else {
                // mid is not the answer;
                // keep on searching in the right half
                l = mid + 1
            }
        }
        return index
    }
}