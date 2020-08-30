package com.github.dkoval.leetcode.challenge

/**
 * [Pancake Sorting](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3441/)
 *
 * Given an array of integers A, We need to sort the array performing a series of pancake flips.
 *
 * In one pancake flip we do the following steps:
 * - Choose an integer `k` where `0 <= k < A.length`.
 * - Reverse the `sub-array A[0...k]`.
 *
 * For example, if `A = [3,2,1,4]` and we performed a pancake flip choosing `k = 2`, we reverse the sub-array `[3,2,1]`,
 * so `A = [1,2,3,4]` after the pancake flip at `k = 2`.
 *
 * Return an array of the k-values of the pancake flips that should be performed in order to sort A.
 * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 */
object PancakeSorting {

    fun pancakeSort(A: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        for (i in A.lastIndex downTo 1) {
            // j starts from 1 since if searchable (i + 1) number appears at the beginning of the array,
            // there no point in flipping
            for (j in 1..i) {
                if (A[j] == i + 1) {
                    flip(A, j)
                    result.add(j + 1)
                    break
                }
            }
            flip(A, i)
            result.add(i + 1)
        }
        return result
    }

    private fun flip(A: IntArray, endIndexInclusive: Int) {
        var i = 0
        var j = endIndexInclusive
        while (i < j) {
            val tmp = A[i]
            A[i] = A[j]
            A[j] = tmp
            i++
            j--
        }
    }
}