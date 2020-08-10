package com.github.dkoval.leetcode.challenge

/**
 * [Excel Sheet Column Number](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/)
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
object ExcelSheetColumnNumber {

    fun titleToNumber(s: String): Int {
        var result = 0
        for (ch in s) {
            result *= 26
            result += (ch - 'A') + 1
        }
        return result
    }
}