package com.github.dkoval.leetcode.challenge

/**
 * [Pow(x, n)](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/)
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 */
interface Pow {
    fun myPow(x: Double, n: Int): Double
}

object PowRecursive: Pow {

    override fun myPow(x: Double, n: Int): Double {
        // n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1], therefore
        // converting n to Long to prevent integer overflow when n = -2^31
        return myPowInternal(x, n.toLong())
    }

    private fun myPowInternal(x: Double, n: Long): Double {
        if (x == 0.0) {
            return if (n != 0L) x else Double.NaN
        }
        if (n == 0L) return 1.0
        if (n == 1L) return x
        if (n < 0) return 1 / myPowInternal(x, -n)
        val p = myPowInternal(x * x, n / 2)
        return if (n % 2 == 0L) p else p * x
    }
}

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