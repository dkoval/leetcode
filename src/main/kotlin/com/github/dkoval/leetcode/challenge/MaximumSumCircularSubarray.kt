package com.github.dkoval.leetcode.challenge

import kotlin.math.max
import kotlin.math.min

/**
 * [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)
 *
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects to the beginning of the array.
 * Formally, ```C[i] = A[i]``` when 0 <= i < A.length, and ```C[i+A.length] = C[i]``` when i >= 0.
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.
 * Formally, for a subarray ```C[i], C[i+1], ..., C[j]```, there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.
 *
 * Constraints:
 *
 * - n == nums.length
 * - 1 <= n <= 3 * 10^4
 * - -3 * 10^4 <= ```nums[i]``` <= 3 * 10^4
 */
object MaximumSumCircularSubarray {

    // Resource: https://www.youtube.com/watch?v=fxT9KjakYPM
    // O(N) time | O(1) space
    fun maxSubarraySumCircular(A: IntArray): Int {
        var total = 0
        var currMaxSum = 0
        var bestMaxSum = Int.MIN_VALUE // global max sum
        var currMinSum = 0
        var bestMinSum = Int.MAX_VALUE // global min sum
        for (x in A) {
            total += x
            // Kadane's algorithm to find MAX sum subarray
            currMaxSum = max(currMaxSum + x, x)
            bestMaxSum = max(currMaxSum, bestMaxSum)
            // Kadane's algorithm to find MIN sum subarray
            currMinSum = min(currMinSum + x, x)
            bestMinSum = min(currMinSum, bestMinSum)
        }

        // bestMaxSum > 0 check handles the edge case where all the values in A[] are negative.
        // For example: A = [-5, -3, -5]
        // in this case total == bestMinSum == -13, bestMaxSum = -3
        return if (bestMaxSum > 0) max(bestMaxSum, total - bestMinSum) else bestMaxSum
    }
}