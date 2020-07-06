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
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] < 9) {
                digits[i] += 1
                return digits
            } else {
                digits[i] = 0
            }
        }
        if (digits[0] == 0) {
            return digits.copyInto(IntArray(digits.size + 1), 1, digits.size).also { it[0] = 1 }
        }
        return digits
    }
}