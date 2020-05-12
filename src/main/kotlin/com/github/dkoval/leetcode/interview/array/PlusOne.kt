package com.github.dkoval.leetcode.interview.array

/**
 * [Plus One](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/)
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
object PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        val result = IntArray(digits.size)
        var index = digits.lastIndex
        var overflow: Boolean
        do {
            val i = digits[index] + 1
            result[index] = i % 10
            overflow = i == 10
            index--
        } while (index >= 0 && overflow)

        if (index >= 0) {
            digits.copyInto(result, startIndex = 0, endIndex = index + 1)
            return result
        }

        if (overflow) {
            val extResult = IntArray(result.size + 1)
            extResult[0] = 1
            result.copyInto(extResult, destinationOffset = 1)
            return extResult
        }

        return result
    }
}