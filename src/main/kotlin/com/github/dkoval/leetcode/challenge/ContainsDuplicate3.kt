package com.github.dkoval.leetcode.challenge

import java.util.*
import kotlin.math.abs

/**
 * [Contains Duplicate III](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/)
 *
 * Given an array of integers, find out whether there are two distinct indices `i` and `j` in the array such that
 * the absolute difference between ```nums[i]``` and ```nums[j]``` is at most `t` and
 * the absolute difference between `i` and `j` is at most `k`.
 */
interface ContainsDuplicate3 {

    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean
}

// Time complexity: O(N^2), space complexity: O(1)
object ContainsDuplicate3BruteForce : ContainsDuplicate3 {

    override fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (abs(nums[i].toLong() - nums[j].toLong()) <= t && abs(i - j) <= k) return true
            }
        }
        return false
    }
}

// Time complexity: O(N * K), space complexity: O(1)
object ContainsDuplicate3Straightforward: ContainsDuplicate3 {

    override fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until minOf(i + k + 1, nums.size)) {
                if (abs(nums[i].toLong() - nums[j].toLong()) <= t) return true
            }
        }
        return false
    }
}

// Time complexity: O(N * logK), space complexity: O(K)
object ContainsDuplicate3UsingTreeSet : ContainsDuplicate3 {

    override fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        // the problem statement | nums[i] - nums[j] | <= t inequality reduces to 2 cases:
        // 1. nums[i] - nums[j] <= t  <-> nums[i] <= nums[j] + t
        // 2. nums[i] - nums[j] >= -t <-> nums[i] >= nums[j] - t
        val kElements = TreeSet<Long>()
        for (i in nums.indices) {
            val num = nums[i].toLong() // to prevent Int overflow
            val floor = kElements.floor(num + t)
            if (floor != null && nums[i] <= floor) return true
            val ceiling = kElements.ceiling(num - t)
            if (ceiling != null && nums[i] >= ceiling) return true
            kElements.add(num)
            if (i >= k) {
                kElements.remove(nums[i - k].toLong())
            }
        }
        return false
    }
}
