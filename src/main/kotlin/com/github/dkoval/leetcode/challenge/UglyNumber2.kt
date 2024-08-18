package com.github.dkoval.leetcode.challenge

import kotlin.math.min

object UglyNumber2Smart : UglyNumber2 {

    override fun nthUglyNumber(n: Int): Int {
        val ugly = IntArray(n)
        ugly[0] = 1
        var idx2 = 0
        var idx3 = 0
        var idx5 = 0
        var i = 1
        while (i < n) {
            val next2 = ugly[idx2] * 2
            val next3 = ugly[idx3] * 3
            val next5 = ugly[idx5] * 5
            val next = min(min(next2, next3), next5)
            if (next == next2) idx2++
            if (next == next3) idx3++
            if (next == next5) idx5++
            ugly[i++] = next
        }
        return ugly[n - 1]
    }
}