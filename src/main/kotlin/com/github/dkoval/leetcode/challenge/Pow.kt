package com.github.dkoval.leetcode.challenge

object PowIter: Pow {

    override fun myPow(x: Double, n: Int): Double = myPowInternal(x, n.toLong())

    // n is expected to be a non-negative number here
    private fun myPowInternal(x: Double, n: Long): Double {
        if (x == 0.0) {
            return if (n != 0L) x else Double.NaN
        }
        if (n < 0) return 1 / myPowInternal(x, -n)
        var p = 1.0
        var _x = x
        var _n = n
        while (_n > 0) {
            if (_n % 2 != 0L) {
                p *= _x
            }
            _x *= _x // x -> x^2
            _n /= 2 // n -> y / 2
        }
        return p
    }
}