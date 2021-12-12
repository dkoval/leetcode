package com.github.dkoval.leetcode.problems

/**
 * [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Note:
 * - Each of the array element will not exceed 100.
 * - The array size will not exceed 200.
 */
object PartitionEqualSubsetSum {

    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        return canPartition(nums, 0, 0, sum, mutableMapOf())
    }

    private data class Key(val index: Int, val currSum: Int)

    private fun canPartition(
        nums: IntArray,
        index: Int,
        currSum: Int,
        targetSum: Int,
        memo: MutableMap<Key, Boolean>
    ): Boolean {
        if (currSum == targetSum / 2) return true
        if (index == nums.size || currSum > targetSum / 2) return false

        val key = Key(index, currSum)
        if (key in memo) {
            return memo[key]!!
        }

        // include/exclude nums[index] element
        val result = canPartition(nums, index + 1, currSum + nums[index], targetSum, memo)
                || canPartition(nums, index + 1, currSum, targetSum, memo)
        memo[key] = result
        return result
    }
}