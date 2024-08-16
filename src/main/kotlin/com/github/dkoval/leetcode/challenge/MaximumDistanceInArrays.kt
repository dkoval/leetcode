package com.github.dkoval.leetcode.challenge

object MaximumDistanceInArraysKt : MaximumDistanceInArrays {

    // Resource: https://www.youtube.com/watch?v=wH3rIZrg0UM&list=TLPQMDExMDIwMjBVExl83vU_gg&index=1
    override fun maxDistance(arrays: List<List<Int>>): Int {
        if (arrays.size < 2) return 0
        var best = 0
        var minSoFar = arrays[0].first()
        var maxSoFar = arrays[0].last()
        for (i in 1 until arrays.size) {
            val currMin = arrays[i].first()
            val currMax = arrays[i].last()
            best = maxOf(best, currMax - minSoFar, maxSoFar - currMin)
            minSoFar = minOf(minSoFar, currMin)
            maxSoFar = maxOf(maxSoFar, currMax)
        }
        return best
    }
}