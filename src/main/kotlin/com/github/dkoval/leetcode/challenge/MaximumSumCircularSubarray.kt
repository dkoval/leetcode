package com.github.dkoval.leetcode.challenge

import kotlin.math.max
import kotlin.math.min

/**
 * [Maximum Sum Circular Subarray](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/)
 *
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects to the beginning of the array.
 * Formally, ```C[i] = A[i]``` when 0 <= i < A.length, and ```C[i+A.length] = C[i]``` when i >= 0.
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.
 * Formally, for a subarray ```C[i], C[i+1], ..., C[j]```, there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.
 */
object MaximumSumCircularSubarray {

    fun maxSubarraySumCircular(A: IntArray): Int {
        var totalSum = 0
        var maxEndingAt = 0
        var minEndingAt = 0
        var maxSum = Int.MIN_VALUE
        var minSum = Int.MAX_VALUE
        for (x in A) {
            totalSum += x
            // Kadane's algorithm to find MAX sum subarray
            maxEndingAt = max(maxEndingAt + x, x)
            maxSum = max(maxEndingAt, maxSum)
            // Kadane's algorith to find MIN sum subarray
            minEndingAt = min(minEndingAt + x, x)
            minSum = min(minEndingAt, minSum)
        }
        return if (maxSum > 0) max(maxSum, totalSum - minSum) else maxSum
    }
}