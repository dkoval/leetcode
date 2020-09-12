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
        val result = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()
        generateCombination(k, n, 1, combination, result)
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
        for (i in start..9) {
            combination.add(i)
            generateCombination(k, n - i, i + 1, combination, result)
            combination.removeAt(combination.lastIndex) // backtrack
        }
    }
}