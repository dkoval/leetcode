package com.github.dkoval.leetcode.challenge

/**
 * [Largest Divisible Subset](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/)
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 */
object LargestDivisibleSubsetKnowledgeCenter : LargestDivisibleSubset {

    // Resource: https://www.youtube.com/watch?v=8tDM_pfmlrw
    override fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if (nums.size <= 1) {
            return nums.toList()
        }
        nums.sort()
        val result = MutableList(nums.size) { i -> mutableListOf(nums[i]) }
        var maxLength = 1
        var maxIndex = 0
        for (i in nums.lastIndex downTo 0) {
            var maxLengthSoFar = 0
            var maxIndexSoFar = i
            for (j in i + 1 until nums.size) {
                if (nums[j] % nums[i] == 0 && result[j].size > maxLengthSoFar) {
                    maxLengthSoFar = result[j].size
                    maxIndexSoFar = j
                }
            }
            if (maxIndexSoFar != i) {
                result[i].addAll(result[maxIndexSoFar])
                if (maxLengthSoFar + 1 > maxLength) {
                    maxLength = maxLengthSoFar + 1
                    maxIndex = i
                }
            }
        }
        return result[maxIndex]
    }
}