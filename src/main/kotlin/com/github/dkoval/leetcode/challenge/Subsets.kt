package com.github.dkoval.leetcode.challenge

/**
 * [Subsets](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/)
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
interface Subsets {

    fun subsets(nums: IntArray): List<List<Int>>
}

object SubsetsBitmask: Subsets {

    override fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val numSubsets = 1 shl nums.size // 2 ^ nums.size
        for (i in 0 until numSubsets) {
            val subset = mutableListOf<Int>()
            var bits = i
            var pos = 0
            while (bits != 0) {
                val bit = bits and 1
                if (bit == 1) {
                    subset.add(nums[pos])
                }
                bits = bits shr 1
                pos++
            }
            result.add(subset)
        }
        return result
    }
}

object SubsetsIter: Subsets {

    override fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf(emptyList<Int>())
        for (num in nums) {
            val subsetsToAdd = mutableListOf<List<Int>>()
            for (subset in result) {
                val subsetToAdd = subset + num
                subsetsToAdd.add(subsetToAdd)
            }
            result.addAll(subsetsToAdd)
        }
        return result
    }
}

object SubsetsRecursive: Subsets {

    override fun subsets(nums: IntArray): List<List<Int>> = doSubsets(nums, 0)

    private fun doSubsets(nums: IntArray, startIndex: Int): MutableList<List<Int>> {
        if (startIndex == nums.lastIndex) {
            return mutableListOf(emptyList(), listOf(nums.last()))
        }
        val result = doSubsets(nums, startIndex + 1)
        val subsetsToAdd = mutableListOf<List<Int>>()
        for (subset in result) {
            val subsetToAdd = mutableListOf(nums[startIndex]).apply { addAll(subset) }
            subsetsToAdd.add(subsetToAdd)
        }
        result.addAll(subsetsToAdd)
        return result
    }
}