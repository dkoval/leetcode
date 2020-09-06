package com.github.dkoval.leetcode.challenge

/**
 * [Image Overlap](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/)
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.
 * (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units),
 * and place it on top of the other image.  After, the overlap of this translation is the number of positions
 * that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 */
object ImageOverlap {

    fun largestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int =
        maxOf(doLargestOverlap(A, B), doLargestOverlap(B, A))

    private fun doLargestOverlap(A: Array<IntArray>, B: Array<IntArray>): Int {
        val n = A.size
        var maxCount = 0
        for (x in 0 until n) {
            for (y in 0 until n) {
                // (x, y) pair represents a shift
                var count = 0
                // process overlapping region
                for (i in y until n) {
                    for (j in x until n) {
                        if (A[i][j] == 1 && B[i - y][j - x] == 1) count++
                    }
                }
                maxCount = maxOf(maxCount, count)
            }
        }
        return maxCount
    }
}