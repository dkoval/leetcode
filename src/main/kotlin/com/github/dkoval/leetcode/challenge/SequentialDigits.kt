package com.github.dkoval.leetcode.challenge

/**
 * [Sequential Digits](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/)
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range ```[low, high]``` inclusive that have sequential digits.
 *
 * Constraints:
 * - 10 <= low <= high <= 10^9
 */
interface SequentialDigits {

    fun sequentialDigits(low: Int, high: Int): List<Int>
}

object SequentialDigitsIter : SequentialDigits {

    // Time complexity: O(9*log10(high)), space complexity: O(log10(high))
    override fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (digit in 1..9) {
            var num = 0
            var nextDigit = digit
            while (nextDigit < 10) {
                num = num * 10 + nextDigit
                if (num > high) break
                if (num >= low) {
                    result += num
                }
                nextDigit++
            }
        }
        return result.apply { sort() }
    }
}

object SequentialDigitsRecursive : SequentialDigits {

    override fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (digit in 1..9) {
            doSequentialDigits(low, high, 0, digit, result)
        }
        return result.apply { sort() }
    }

    private fun doSequentialDigits(low: Int, high: Int, num: Int, nextDigit: Int, result: MutableList<Int>) {
        if (num > high) return
        if (num >= low) {
            result += num
        }
        if (nextDigit > 9) return
        return doSequentialDigits(low, high, num * 10 + nextDigit, nextDigit + 1, result)
    }
}