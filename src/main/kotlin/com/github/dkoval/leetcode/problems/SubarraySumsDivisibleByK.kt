package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.challenge.SubarraySumsDivisibleByK

object SubarraySumsDivisibleByKRev1 : SubarraySumsDivisibleByK {

    // Resource: https://www.youtube.com/watch?v=u9m-hnlcydk
    override fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val counts = IntArray(k)
        var sum = 0
        for (x in nums) {
            // (sum + x) % K
            sum += x % k
            sum %= k
            if (sum < 0) {
                sum += k
            }
            counts[sum]++
        }

        var ans = counts[0]
        for (c in counts) {
            ans += c * (c - 1) / 2
        }
        return ans
    }
}