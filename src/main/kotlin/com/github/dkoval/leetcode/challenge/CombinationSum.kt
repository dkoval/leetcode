package com.github.dkoval.leetcode.challenge

/**
 * [Combination Sum](https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3481/)
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all
 * unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 */
interface CombinationSum {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>>
}

object CombinationSumKt : CombinationSum {

    override fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        genCombinationSum(candidates, target, 0, mutableListOf(), result)
        return result
    }

    private fun genCombinationSum(
        candidates: IntArray,
        target: Int,
        idx: Int,
        combination: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target < 0) return
        if (target == 0) {
            result.add(ArrayList(combination))
            return
        }
        for (i in idx until candidates.size) {
            if (candidates[i] > target) continue
            combination.add(candidates[i])
            genCombinationSum(candidates, target - candidates[i], i, combination, result)
            combination.removeAt(combination.lastIndex) // backtrack
        }
    }
}