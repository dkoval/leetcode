package com.github.dkoval.leetcode.challenge

object SubsetsBitmask : Subsets {

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

object SubsetsIter : Subsets {

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

object SubsetsRecursive : Subsets {

    override fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        doSubsets(nums, 0, mutableListOf(), result)
        return result
    }

    private fun doSubsets(nums: IntArray, idx: Int, subset: MutableList<Int>, result: MutableList<List<Int>>) {
        if (idx == nums.size) {
            result.add(subset.toList())
            return
        }

        // option #1: take nums[idx]
        subset.add(nums[idx])
        doSubsets(nums, idx + 1, subset, result)
        subset.removeLast()

        // option #2: skip nums[idx]
        doSubsets(nums, idx + 1, subset, result)
    }
}

object SubsetsRecursive2 : Subsets {

    override fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        doSubsets(nums, 0, mutableListOf(), result)
        return result
    }

    private fun doSubsets(nums: IntArray, idx: Int, subset: MutableList<Int>, result: MutableList<List<Int>>) {
        result.add(ArrayList(subset))
        for (i in idx until nums.size) {
            subset.add(nums[i])
            doSubsets(nums, i + 1, subset, result)
            subset.removeAt(subset.size - 1)
        }
    }
}