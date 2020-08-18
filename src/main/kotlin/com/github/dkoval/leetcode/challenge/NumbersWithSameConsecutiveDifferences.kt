package com.github.dkoval.leetcode.challenge

/**
 * [Numbers With Same Consecutive Differences](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/)
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself.
 * For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 * Note:
 * - 1 <= N <= 9
 * - 0 <= K <= 9
 */
object NumbersWithSameConsecutiveDifferences {

    // Resource: https://www.youtube.com/watch?v=TAfXh2l9FyA&list=PL1w8k37X_6L9uIBLia6XiFuC9q4hYcazJ&index=18
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        val result = mutableListOf<Int>()
        if (N == 1) {
            result.add(0)
        }
        for (d in 1..9) {
            dfs(d, N - 1, K, result)
        }
        return result.toIntArray()
    }

    private fun dfs(num: Int, N: Int, K: Int, result: MutableList<Int>) {
        if (N == 0) {
            result.add(num)
            return
        }
        val lastDigit = num % 10
        if (lastDigit >= K) {
            dfs(num * 10 + lastDigit - K, N - 1, K, result)
        }
        if (K > 0 && lastDigit < 10 - K) { // extra K > 0 check is needed here to prevents duplicates in case K = 0
            dfs(num * 10 + lastDigit + K, N - 1, K, result)
        }
    }
}