package com.github.dkoval.leetcode.challenge

/**
 * [K-diff Pairs in an Array](https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/)
 *
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (```nums[i], nums[j]```), where the following are true:
 * - 0 <= i, j < nums.length
 * - i != j
 * - a <= b
 * - b - a == k
 */
interface KDiffPairsInArray {

    fun findPairs(nums: IntArray, k: Int): Int
}

object KDiffPairsInArrayBruteForce : KDiffPairsInArray {

    override fun findPairs(nums: IntArray, k: Int): Int {
        val uniquePairs = mutableSetOf<String>()
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i != j && nums[j] - nums[i] == k) {
                    val pair = "(${nums[j]},${nums[i]})"
                    if (pair !in uniquePairs) {
                        uniquePairs.add(pair)
                    }
                }
            }
        }
        return uniquePairs.size
    }
}

object KDiffPairsInArrayInNLogNTime : KDiffPairsInArray {

    override fun findPairs(nums: IntArray, k: Int): Int {
        nums.sort()
        var count = 0
        var prev: Int? = null
        for (i in 0 until nums.size - 1) {
            if (nums[i] == prev) continue
            val index = nums.binarySearch(nums[i] + k, i + 1, nums.size)
            if (index >= 0) count++
            prev = nums[i]
        }
        return count
    }
}