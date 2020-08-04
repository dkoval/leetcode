package com.github.dkoval.leetcode.problems

/**
 * [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)
 *
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 */
object SubarraySumsDivisibleByK {

    // Resource: https://www.youtube.com/watch?v=u9m-hnlcydk
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val counts = IntArray(K)
        var sum = 0
        for (a in A) {
            sum += (a % K + K) % K
            counts[sum % K]++
        }
        var result = counts[0]
        for (c in counts) {
            result += (c * (c - 1)) / 2
        }
        return result
    }
}