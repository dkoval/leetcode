package com.github.dkoval.leetcode.challenge

/**
 * [Combination Sum III](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/)
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used
 * and each combination should be a unique set of numbers.
 *
 * Note:
 * - All numbers will be positive integers.
 * - The solution set must not contain duplicate combinations.
 */
object CombinationSum3 {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        // the smallest sum we can get with k numbers:
        // 1 + 2 + ... + k = k * (k + 1) / 2
        if (k * (k + 1) / 2 > n) {
            return emptyList()
        }

        val result = mutableListOf<List<Int>>()
        generateCombination(k, n, 1, mutableListOf(), result)
        return result
    }

    private fun generateCombination(
        k: Int,
        n: Int,
        start: Int,
        combination: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (combination.size == k) {
            if (n == 0) {
                result.add(ArrayList(combination))
            }
            return
        }

        // exhaustively generate all possible combinations
        for (x in start..9) {
            if (n - x < 0) {
                // next x will be even greater, therefore stop here
                break
            }

            combination.add(x)
            generateCombination(k, n - x, x + 1, combination, result)
            combination.removeAt(combination.lastIndex) // backtrack
        }
    }
}