package com.github.dkoval.leetcode.interview.strings

/**
 * [String to Integer (atoi)](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/)
 *
 * Implement `atoi` which converts a string to an integer.
 */
object StringToInteger {

    fun myAtoi(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }

        // skip whitespaces
        var i = 0
        while (i < str.length && str[i] == ' ') {
            i++
        }

        // if str is empty or it contains only whitespace characters, or
        // the first character of non-whitespace sequence in str is not a valid integral number,
        // then no conversion is performed
        if (i == str.length || str[i].isLetter()) {
            return 0
        }

        // takes an optional initial plus or minus sign followed by as many numerical digits as possible
        val isPositive = when (str[i]) {
            '+' -> {
                i++
                true
            }
            '-' -> {
                i++
                false
            }
            else -> true
        }

        var result = 0
        while (i < str.length && str[i].isDigit()) {
            val digit = str[i] - '0'
            if (canCauseIntOverflow(digit, if (isPositive) result else -result)) {
                return if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
            }
            result = result * 10 + digit
            i++
        }
        return if (isPositive) result else -result
    }

    private fun canCauseIntOverflow(digit: Int, result: Int): Boolean {
        // 32-bit signed integer range: [−2^31,  2^31 − 1]
        // - if result > Int.MAX_VALUE / 10, then result * 10 + digit is guaranteed to overflow
        // - if result == Int.MAX_VALUE / 10, then result * 10 + digit overflows IFF digit > 7, i.e. last digit of Int.MAX_VALUE
        // - if result < Int.MIN_VALUE / 10, then result * 10 + digit is guaranteed to overflow
        // - if result == Int.MIN_VALUE / 10, then result * 10 + digit overflows IFF digit < -8. i.e. last digit of Int.MIN_VALUE
        if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10)) {
            return true
        }
        if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && -digit < Int.MIN_VALUE % 10)) {
            return true
        }
        return false
    }
}