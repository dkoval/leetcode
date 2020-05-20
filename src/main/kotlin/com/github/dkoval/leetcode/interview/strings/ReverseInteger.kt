package com.github.dkoval.leetcode.interview.strings

import java.util.*

/**
 * [Reverse Integer](https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/)
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
object ReverseInteger {

    fun reverse(x: Int): Int = when {
        x < 0 -> -reversePositiveInt(-x)
        x > 0 -> reversePositiveInt(x)
        else -> 0
    }

    private fun reversePositiveInt(x: Int): Int {
        val digits = digitsInReverseOrder(x)
        return convertToInt(digits)
    }

    private fun digitsInReverseOrder(x: Int): Deque<Int> {
        var num = x
        val digits = LinkedList<Int>()
        var seenFirstNonZero = false
        while (num != 0) {
            val digit = num % 10
            // ignore trailing zeros
            if (digit > 0 && !seenFirstNonZero) {
                seenFirstNonZero = true
            }
            if (seenFirstNonZero) {
                digits.add(digit)
            }
            num /= 10
        }
        return digits
    }

    private fun convertToInt(digits: Deque<Int>): Int {
        // max 32-bit signed integer is 2147483647
        if (digits.size > 10 || digits.size == 10 && digits.peekFirst() > 2) {
            // handle overflow
            return 0
        }
        var result = 0
        for (i in digits.size - 1 downTo 0) {
            result += digits.pop() * 10.pow(i)
            if (result < 0) {
                // handle overflow
                return 0
            }
        }
        return result
    }

    private fun Int.pow(n: Int): Int {
        if (n < 0) {
            throw IllegalArgumentException("n must be a non-negative integer")
        }
        var result = 1
        for (i in 1..n) {
            result *= this
        }
        return result
    }
}