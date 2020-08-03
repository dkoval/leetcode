package com.github.dkoval.leetcode.problems

/**
 * [Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
object ExcelSheetColumnTitle {

    fun convertToTitle(n: Int): String {
        val result = StringBuilder()
        var x = n
        while (x != 0) {
            val digit = 'A' + ((x - 1) % 26)
            x = (x - 1) / 26
            result.append(digit)
        }
        return result.reverse().toString()
    }
}