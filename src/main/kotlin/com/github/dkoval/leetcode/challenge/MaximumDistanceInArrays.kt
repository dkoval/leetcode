package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [Maximum Distance in Arrays](https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3479/)
 *
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from
 * two different arrays (each array picks one) and calculate the distance. We define the distance between
 * two integers `a` and `b` to be their absolute difference `|a-b|`. Your task is to find the maximum distance.
 */
object MaximumDistanceInArrays {

    // Resource: https://www.youtube.com/watch?v=wH3rIZrg0UM&list=TLPQMDExMDIwMjBVExl83vU_gg&index=1
    fun maxDistance(arrays: List<List<Int>>): Int {
        if (arrays.size < 2) return 0
        var min = arrays[0].first()
        var max = arrays[0].last()
        var result = Int.MIN_VALUE
        for (i in 1 until arrays.size) {
            val currMin = arrays[i].first()
            val currMax = arrays[i].last()
            result = maxOf(result, abs(currMax - min), abs(max - currMin))
            min = minOf(min, currMin)
            max = maxOf(max, currMax)
        }
        return result
    }
}