package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Sort Array By Parity](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/)
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
 * all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */
interface SortArrayByParity {

    fun sortArrayByParity(A: IntArray): IntArray
}

// Complexity: time - O(N), space - O(N)
object SortArrayByParityNaive: SortArrayByParity {

    override fun sortArrayByParity(A: IntArray): IntArray {
        val even: Queue<Int> = LinkedList()
        val odd: Queue<Int> = LinkedList()
        for (a in A) {
            if (a % 2 == 0) {
                even.add(a)
            } else {
                odd.add(a)
            }
        }
        val result = IntArray(A.size)
        var i = 0
        val n = even.size
        while (!even.isEmpty() || !odd.isEmpty()) {
            result[i] = if (i < n) even.poll() else odd.poll()
            i++
        }
        return result
    }
}

// Complexity: time - O(N), space - O(1)
object SortArrayByParityOptimal: SortArrayByParity {

    override fun sortArrayByParity(A: IntArray): IntArray {
        var i = 0 // to point to the last element of the `even` part
        for (j in A.indices) {
            if (A[j] % 2 == 0) {
                val tmp = A[i]
                A[i] = A[j]
                A[j] = tmp
                i++
            }
        }
        return A
    }
}