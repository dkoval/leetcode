package com.github.dkoval.leetcode.challenge

import kotlin.random.Random

/**
 * [Random Point in Non-overlapping Rectangles](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3433/)
 *
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which
 * randomly and uniformly picks an integer point in the space covered by the rectangles.
 *
 * Note:
 * - An integer point is a point that has integer coordinates.
 * - A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * `i`th rectangle = ```rects[i]``` = ```[x1, y1, x2, y2]```, where ```[x1, y1]``` are the integer
 * coordinates of the bottom-left corner, and ```[x2, y2]``` are the integer coordinates of the top-right corner.
 * - length and width of each rectangle does not exceed 2000.
 * - ```1 <= rects.length <= 100```
 * - `pick` return a point as an array of integer coordinates ```[p_x, p_y]```
 * - `pick` is called at most 10000 times.
 */
class RandomPointInNonOverlappingRectangles(private val rects: Array<IntArray>) {
    private val buckets = IntArray(rects.size)

    init {
        var totalNumPoints = 0
        for (i in rects.indices) {
            val (x1, y1, x2, y2) = rects[i]
            val numPointsX = x2 - x1 + 1
            val numPointsY = y2 - y1 + 1
            val numPointsInRect = numPointsX * numPointsY
            totalNumPoints += numPointsInRect
            buckets[i] = totalNumPoints
        }
    }

    // Resource: https://www.youtube.com/watch?v=8kwPXbTMSnk&list=PL1w8k37X_6L9uIBLia6XiFuC9q4hYcazJ&index=23&t=1160s
    fun pick(): IntArray {
        val pointIndex = Random.nextInt(buckets.last()) // generates a random number in [0, totalNumPoints - 1] range
        val rectIndex = findRectIndex(pointIndex)
        return pointIndexToPoint2D(pointIndex, rectIndex)
    }

    private fun findRectIndex(pointIndex: Int): Int {
        // binary search
        var l = 0
        var r = buckets.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            if (buckets[mid] <= pointIndex) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return l
    }

    private fun pointIndexToPoint2D(pointIndex: Int, rectIndex: Int): IntArray {
        val (x1, y1, x2, y2) = rects[rectIndex]
        val numPointsX = x2 - x1 + 1
        val numPointsY = y2 - y1 + 1
        val numPointsInRect = numPointsX * numPointsY
        val bucketStartIndex = buckets[rectIndex] - numPointsInRect
        val offset = pointIndex - bucketStartIndex
        return intArrayOf(x1 + offset % numPointsX, y1 + offset / numPointsX)
    }
}