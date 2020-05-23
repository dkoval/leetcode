package com.github.dkoval.leetcode.challenge

import kotlin.math.max
import kotlin.math.min

/**
 * [Interval List Intersections](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/)
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 */
object IntervalListIntersections {

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i < A.size && j < B.size) {
            // check if intervals A[i] and B[j] intersect
            val start = max(A[i][0], B[j][0])
            val end = min(A[i][1], B[j][1])
            if (start <= end) {
                result.add(intArrayOf(start, end))
            }
            // for the interval with smaller upper boundary, set the pointer to the next item in the list of intervals
            if (A[i][1] < B[j][1]) {
                i++
            } else {
                j++
            }
        }
        return result.toTypedArray()
    }
}