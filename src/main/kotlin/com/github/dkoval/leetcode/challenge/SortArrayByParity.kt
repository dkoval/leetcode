package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
 * all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - 0 <= nums(i) <= 5000
 */
interface SortArrayByParity {

    fun sortArrayByParity(A: IntArray): IntArray
}

// Complexity: time - O(N), space - O(N)
object SortArrayByParityNaive: SortArrayByParity {

    override fun sortArrayByParity(A: IntArray): IntArray {
        val evens: Queue<Int> = ArrayDeque()
        val odds: Queue<Int> = ArrayDeque()
        for (a in A) {
            if (a % 2 == 0) {
                evens.add(a)
            } else {
                odds.add(a)
            }
        }

        var i = 0
        while (!evens.isEmpty() || !odds.isEmpty()) {
            A[i++] = if (!evens.isEmpty()) evens.poll() else odds.poll()
        }
        return A
    }
}

// Complexity: time - O(N), space - O(1)
object SortArrayByParityOptimal: SortArrayByParity {

    override fun sortArrayByParity(A: IntArray): IntArray {
        var writeIdx = 0 // points to the next vacant position of the `even` part
        for (i in A.indices) {
            if (A[i] % 2 == 0) {
                A.swap(writeIdx, i)
                writeIdx++
            }
        }
        return A
    }

    private fun IntArray.swap(i: Int, j: Int) {
        if (i != j) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }
    }
}