package com.github.dkoval.leetcode.challenge

/**
 * [Majority Element](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/)
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
interface MajorityElement {

    fun majorityElement(nums: IntArray): Int
}

// Time complexity: O(N), space complexity: O(N)
object MajorityElementUsingHashMap : MajorityElement {

    override fun majorityElement(nums: IntArray): Int {
        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            val count = counts[num]
            if (count != null && count + 1 > nums.size / 2) {
                return num
            } else {
                counts[num] = (count ?: 0) + 1
            }
        }
        return -1
    }
}

// Time complexity: O(N), space complexity: O(1)
object MajorityElementUsingBoyerMooreVotingAlgorithm : MajorityElement {

    override fun majorityElement(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 1
        for (i in 1 until nums.size) {
            if (count == 0) {
                candidate = nums[i]
            }
            count += if (nums[i] == candidate) 1 else -1
        }
        return candidate
    }
}