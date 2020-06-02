package com.github.dkoval.leetcode.interview.strings

/**
 * [Reverse Integer](https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/)
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
object ReverseInteger {

    fun reverse(x: Int): Int {
        var num = x
        var result = 0
        while (num != 0) {
            val digit = num % 10
            num /= 10
            // Handle overflow beforehand ([min; max] 32-bit signed integers are [-2147483648; 2147483647]):
            // - if result > Int.MAX_VALUE / 10, then result * 10 + digit is guaranteed to overflow
            // - if result == Int.MAX_VALUE / 10, then result * 10 + digit overflows IFF digit > 7, i.e. last digit of Int.MAX_VALUE
            // - if result < Int.MIN_VALUE / 10, then result * 10 + digit is guaranteed to overflow
            // - if result == Int.MIN_VALUE / 10, then result * 10 + digit overflows IFF digit < -8. i.e. last digit of Int.MIN_VALUE
            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10)) {
                return 0
            }
            if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && digit < Int.MIN_VALUE % 10)) {
                return 0
            }
            result = result * 10 + digit
        }
        return result
    }
}