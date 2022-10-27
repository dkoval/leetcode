package com.github.dkoval.leetcode.challenge

object ImageOverlapRev2 : ImageOverlap {

    // https://www.youtube.com/watch?v=zfjBapE3Y6E
    override fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int =
        maxOf(doLargestOverlap(img1, img2), doLargestOverlap(img2, img1))

    private fun doLargestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val n = img1.size
        var maxCount = 0
        for (dx in 0 until n) {
            for (dy in 0 until n) {
                // (dx, dy) pair represents a shift
                var count = 0
                // process overlapping region
                for (i in dy until n) {
                    for (j in dx until n) {
                        if (img1[i][j] == 1 && img2[i - dy][j - dx] == 1) count++
                    }
                }
                maxCount = maxOf(maxCount, count)
            }
        }
        return maxCount
    }
}