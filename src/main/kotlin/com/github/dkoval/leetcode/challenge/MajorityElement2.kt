package com.github.dkoval.leetcode.challenge

/**
 * [Majority Element II](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3469/)
 *
 * Given an integer array of size n, find all elements that appear more than ```⌊n/3⌋``` times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 */
interface MajorityElement2 {

    fun majorityElement(nums: IntArray): List<Int>
}

// Time complexity: O(N),
// Space complexity: O(N)
object MajorityElement2UsingHashMap : MajorityElement2 {

    override fun majorityElement(nums: IntArray): List<Int> {
        if (nums.isEmpty()) return listOf()
        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }
        val majorityCount = nums.size / 3
        val result = mutableListOf<Int>()
        for ((num, count) in counts) {
            if (count > majorityCount) {
                result += num
            }
        }
        return result
    }
}

// Time complexity: O(N)
// Space complexity: O(1)
object MajorityElement2UsingBoyerMooreVotingAlgorithm : MajorityElement2 {

    override fun majorityElement(nums: IntArray): List<Int> {
        // fact: there exists no more than 2 elements that appear more than n/3 times in the array
        var candidate1: Int? = null
        var candidate2: Int? = null
        var count1 = 0
        var count2 = 0
        for (num in nums) {
            when {
                candidate1 == num -> count1++
                candidate2 == num -> count2++
                count1 == 0 -> {
                    candidate1 = num
                    count1++
                }
                count2 == 0 -> {
                    candidate2 = num
                    count2++
                }
                else -> {
                    count1--
                    count2--
                }
            }
        }
        // make sure candidate1 & candidate2 occur more than n/3 times
        count1 = 0
        count2 = 0
        for (num in nums) {
            if (candidate1 == num) count1++
            else if (candidate2 == num) count2++
        }
        val result = mutableListOf<Int>()
        val majorityCount = nums.size / 3
        if (count1 > majorityCount) {
            result += candidate1!!
        }
        if (count2 > majorityCount) {
            result += candidate2!!
        }
        return result
    }
}