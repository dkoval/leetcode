package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.mock.PlusOne

object PlusOneKt : PlusOne {

    override fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] < 9) {
                digits[i] += 1
                return digits
            } else {
                digits[i] = 0
            }
        }
        if (digits[0] == 0) {
            return IntArray(digits.size + 1).also { it[0] = 1 }
        }
        return digits
    }
}