package com.github.dkoval.leetcode.challenge

import kotlin.math.max

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
        val k = kadane(A)
        var sum = 0
        for (i in A.indices) {
            sum += A[i]
            A[i] = -A[i]
        }
        val circularSum = sum + kadane(A)
        return if (circularSum > k && circularSum != 0) circularSum else k
    }

    private fun kadane(A: IntArray): Int {
        var curSum = A[0]
        var maxSum = curSum
        for (i in 1 until A.size) {
            curSum = max(A[i], curSum + A[i])
            maxSum = max(curSum, maxSum)
        }
        return maxSum
    }
}