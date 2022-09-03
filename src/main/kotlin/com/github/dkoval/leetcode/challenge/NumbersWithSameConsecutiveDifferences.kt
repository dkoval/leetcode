package com.github.dkoval.leetcode.challenge

/**
 * [Numbers With Same Consecutive Differences](https://leetcode.com/problems/numbers-with-same-consecutive-differences/)
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself.
 * For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 * Note:
 * - 2 <= N <= 9
 * - 0 <= K <= 9
 */
object NumbersWithSameConsecutiveDifferences {

    // Resource: https://www.youtube.com/watch?v=TAfXh2l9FyA&list=PL1w8k37X_6L9uIBLia6XiFuC9q4hYcazJ&index=18
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        // Analysis:
        // |d[i] - d[i + 1]| = k => d[i + 1] = d[i] + k, or d[i + 1] = d[i] - k
        //
        // trivia #1: in a n-digits long number x, there are (n - 1) "spaces" where +/- k are to be put in:
        // x = d1_d2_d3_ ... _d9
        //
        // trivia #2: there are 9 possibilities to choose the very 1st digit (1..9), therefore
        // the total number of all possible such numbers is 9 * 2^8 ~ 2K (ok to brute-force)
        val ans = mutableListOf<Int>()
        for (digit in 1..9) {
            generate(digit, N - 1, K, ans)
        }
        return ans.toIntArray()
    }

    private fun generate(x: Int, N: Int, K: Int, ans: MutableList<Int>) {
        if (N == 0) {
            ans.add(x)
            return
        }

        val lastDigit = x % 10
        if (lastDigit + K in 0..9) {
            generate(x * 10 + lastDigit + K, N - 1, K, ans)
        }
        // extra K > 0 check is needed here to prevent duplicates if K = 0
        if (K > 0 && lastDigit - K in 0..9) {
            generate(x * 10 + lastDigit - K, N - 1, K, ans)
        }
    }
}