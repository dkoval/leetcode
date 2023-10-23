package com.github.dkoval.leetcode.challenge

object PowerOfFourRev2 : PowerOfFour {

    override fun isPowerOfFour(n: Int): Boolean {
        if (n == 0 || n == Int.MIN_VALUE) {
            return false
        }
        return (n and (n - 1) == 0) && // power of 2 check
                (n and 0xAAAAAAAA.toInt() == 0) // filter out 2, 8, 32, ...
    }
}