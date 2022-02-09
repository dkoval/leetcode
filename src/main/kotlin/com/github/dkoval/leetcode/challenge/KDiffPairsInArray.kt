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

// Time complexity: O(N^2), space complexity: O(N)
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

// Time complexity: O(N), space complexity: O(N)
object KDiffPairsInArrayUsingSet : KDiffPairsInArray {

    override fun findPairs(nums: IntArray, k: Int): Int {
        // |x - y| = k, k > 0
        // x - y = k  <=> y = x - k
        // x - y = -k <=> y = x + k
        val seen = mutableSetOf<Int>()
        // To make pairs are unique, i.e. (1, 3) and (3, 1) are considered the same,
        // keep track of a pair's first number, the smaller one.
        val pairFirstNumbers = mutableSetOf<Int>()
        for (x in nums) {
            // x - y = k
            if (x - k in seen) {
                pairFirstNumbers += x
            }

            // x - y = -k
            if (x + k in seen) {
                pairFirstNumbers += x + k
            }

            seen += x;
        }
        return pairFirstNumbers.size
    }
}

// Time complexity: O(N*LogN), space complexity: O(1)
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

object KDiffPairsInArrayInNLogNTimeWithCustomBinarySearch : KDiffPairsInArray {

    override fun findPairs(nums: IntArray, k: Int): Int {
        nums.sort()
        var count = 0
        var prev: Int? = null
        for (i in 0 until nums.size - 1) {
            if (nums[i] == prev) continue
            val index = binarySearch(nums, i + 1, nums.lastIndex, nums[i] + k)
            if (index >= 0) count++
            prev = nums[i]
        }
        return count
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, key: Int): Int {
        var left = start
        var right = end
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < key -> left = mid + 1
                nums[mid] > key -> right = mid - 1
                else -> return mid
            }
        }
        return -1
    }
}