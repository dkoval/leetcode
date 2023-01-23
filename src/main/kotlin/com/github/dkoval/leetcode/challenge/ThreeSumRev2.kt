package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.ThreeSum

/**
 * [3Sum](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/)
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 */
object ThreeSumRev2 : ThreeSum {

    // Resource: https://www.youtube.com/watch?v=Ca7k53qcTic
    override fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 2) {
            // prevent duplicate triplets
            if (i != 0 && nums[i] == nums[i - 1]) continue
            // since nums[i] is fixed at this point, the scope reduces to 2-sum problem
            twoSum(i, nums, result)
        }
        return result
    }

    private fun twoSum(i: Int, nums: IntArray, result: MutableList<List<Int>>) {
        var j = i + 1
        var k = nums.lastIndex
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[j], nums[k]))
                    // prevent duplicate triples
                    while (j < k && nums[j] == nums[j + 1]) j++
                    // prevent duplicate triples
                    while (j < k && nums[k] == nums[k - 1]) k--
                    j++
                    k--
                }
                sum > 0 -> k-- // since nums[] is sorted in asc order, decrementing k will reduce the triplet sum
                else -> j++ // again, since nums[] is sorted in asc order, incrementing j will increase the triplet sum
            }
        }
    }
}