package com.github.dkoval.leetcode.interview.strings

/**
 * [Count and Say](https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/886/)
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * ```
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * ```
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * You can do so recursively, in other words from the previous member read off the digits,
 * counting the number of digits in groups of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 */
object CountAndSay {

    fun countAndSay(n: Int): String {
        var result = "1"
        if (n == 1) return result
        repeat(n - 1) {
            var currDigit = result[0]
            var count = 0
            result = buildString {
                for (digit in result) {
                    if (digit == currDigit) {
                        count++
                    } else {
                        append(count).append(currDigit)
                        currDigit = digit
                        count = 1
                    }
                }
                append(count).append(currDigit)
            }
        }
        return result
    }
}