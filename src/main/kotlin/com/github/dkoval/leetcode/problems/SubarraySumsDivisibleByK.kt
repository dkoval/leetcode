package com.github.dkoval.leetcode.problems

/**
 * [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)
 *
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 3 * 10^4
 * - -10^4 <= ```nums[i]``` <= 10^4
 * - 2 <= k <= 10^4
 */
object SubarraySumsDivisibleByK {

    // Resource: https://www.youtube.com/watch?v=u9m-hnlcydk
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val counts = IntArray(K)
        var sum = 0
        for (x in A) {
            // (sum + x) % K
            sum += x % K
            sum %= K
            if (sum < 0) {
                sum += K
            }
            counts[sum]++;
        }

        var ans = counts[0]
        for (c in counts) {
            ans += c * (c - 1) / 2
        }
        return ans
    }
}