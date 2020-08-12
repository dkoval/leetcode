package com.github.dkoval.leetcode.challenge

/**
 * [Pascal's Triangle II](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/)
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
object PascalTriangle2 {

    fun getRow(rowIndex: Int): List<Int> {
        val result = IntArray(rowIndex + 1)
        result[0] = 1
        for (currRowIndex in 0..rowIndex) {
            var prev = 1
            for (i in 1 until currRowIndex) {
                val tmp = result[i]
                result[i] += prev
                prev = tmp
            }
            result[currRowIndex] = 1
        }
        return result.asList()
    }
}