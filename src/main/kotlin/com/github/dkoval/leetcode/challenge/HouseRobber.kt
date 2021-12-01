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

// O(N) time | O(N) space
object HouseRobberDPTopDown : HouseRobber {

    override fun rob(nums: IntArray): Int {
        val n = nums.size
        val memo = arrayOfNulls<Int>(n)
        return doRob(nums, 0, memo)
    }

    // Returns the maximum amount of money you can rob from nums[idx:] houses
    private fun doRob(nums: IntArray, idx: Int, memo: Array<Int?>): Int {
        if (idx >= nums.size) {
            return 0
        }

        if (memo[idx] != null) {
            return memo[idx]!!
        }

        // option #1: rob idx-th house
        val moneyIfRob = nums[idx] + doRob(nums, idx + 2, memo)

        // option #2: skip idx-th house
        val moneyIfSkip = doRob(nums, idx + 1, memo)

        // take the maximum of two options and cache the result
        return maxOf(moneyIfRob, moneyIfSkip).also { memo[idx] = it }
    }
}

// Time complexity: O(N), space complexity: O(N)
object HouseRobberDPBottomUp : HouseRobber {

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
object HouseRobberDPBottomUpSpaceOptimized : HouseRobber {

    override fun rob(nums: IntArray): Int {
        var first = 0
        var second = 0
        for (num in nums) {
            val third = maxOf(num + first, second)
            first = second
            second = third
        }
        return second
    }
}