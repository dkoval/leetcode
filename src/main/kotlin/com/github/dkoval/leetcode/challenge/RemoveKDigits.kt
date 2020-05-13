package com.github.dkoval.leetcode.challenge

/**
 * [Remove K Digits](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/)
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * - The length of num is less than 10002 and will be ≥ k.
 * - The given num does not contain any leading zero.
 */
object RemoveKDigits {

    fun removeKdigits(num: String, k: Int): String {
        if (k >= num.length) {
            return "0"
        }
        // if all digits are in increasing order, then delete last digit,
        // otherwise delete a digit for which next digit is smaller
        val sb = StringBuilder(num)
        for (count in 0 until k) {
            var i = 0
            while (i < sb.length - 1 && sb[i] <= sb[i + 1]) {
                i++
            }
            sb.deleteCharAt(i)
        }
        sb.removeLeadingZeros()
        return if (sb.isNotEmpty()) sb.toString() else "0"
    }

    private fun StringBuilder.removeLeadingZeros(): StringBuilder {
        while (isNotEmpty() && this[0] == '0') {
            deleteCharAt(0)
        }
        return this
    }
}