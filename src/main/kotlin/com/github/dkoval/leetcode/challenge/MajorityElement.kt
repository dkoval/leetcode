package com.github.dkoval.leetcode.challenge

/**
 * [Majority Element](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/)
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
object MajorityElement {

    fun majorityElement(nums: IntArray): Int {
        val frequenciesByNum = frequencies(nums)
        var majorityElement: MajorityElement? = null
        for ((num, frequency) in frequenciesByNum.entries) {
            if (frequency > nums.size / 2) {
                if (majorityElement == null) {
                    majorityElement = MajorityElement(num, frequency)
                } else if (frequency > majorityElement.frequency) {
                    majorityElement.num = num
                    majorityElement.frequency = frequency
                }
            }
        }
        return majorityElement?.num ?: throw IllegalStateException("No majority element found")
    }

    private data class MajorityElement(var num: Int, var frequency: Int)

    private fun frequencies(nums: IntArray): Map<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        for (num in nums) {
            val frequency = result[num]
            if (frequency != null) {
                result[num] = frequency + 1
            } else {
                result[num] = 1
            }
        }
        return result
    }
}