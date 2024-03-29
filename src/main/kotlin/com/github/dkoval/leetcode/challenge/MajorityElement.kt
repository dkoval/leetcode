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
        for (x in nums) {
            val count = (counts[x] ?: 0) + 1
            if (count > nums.size / 2) {
                return x
            }
            counts[x] = count
        }
        return -1
    }
}

// Time complexity: O(N), space complexity: O(1)
object MajorityElementUsingBoyerMooreVotingAlgorithm : MajorityElement {

    // Good read: https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    override fun majorityElement(nums: IntArray): Int {
        var candidate = 42 // can be set to any value
        var count = 0
        for (x in nums) {
            if (count == 0) {
                candidate = x
            }
            count += if (x == candidate) 1 else -1
        }
        return candidate
    }
}