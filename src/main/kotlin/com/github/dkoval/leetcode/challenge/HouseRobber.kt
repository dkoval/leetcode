package com.github.dkoval.leetcode.challenge

/**
 * [House Robber](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3459/)
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 */
interface HouseRobber {

    fun rob(nums: IntArray): Int
}

// Time complexity: O(N), space complexity: O(N)
object HouseRobberDPArray : HouseRobber {

    override fun rob(nums: IntArray): Int = when (nums.size) {
        0 -> 0
        1 -> nums[0]
        2 -> maxOf(nums[0], nums[1])
        else -> {
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            dp[1] = maxOf(nums[0], nums[1])
            for (i in 2 until dp.size) {
                dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
            }
            dp[dp.lastIndex]
        }
    }
}

// Time complexity: O(N), space complexity: O(1)
object HouseRobberDPSpaceOptimized : HouseRobber {

    override fun rob(nums: IntArray): Int = when (nums.size) {
        0 -> 0
        1 -> nums[0]
        2 -> maxOf(nums[0], nums[1])
        else -> {
            var first = nums[0]
            var second = maxOf(nums[0], nums[1])
            for (i in 2 until nums.size) {
                val third = maxOf(nums[i] + first, second)
                first = second
                second = third
            }
            second
        }
    }
}