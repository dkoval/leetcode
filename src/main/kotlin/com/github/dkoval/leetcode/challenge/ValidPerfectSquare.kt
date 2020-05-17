package com.github.dkoval.leetcode.challenge

import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * [Valid Perfect Square](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/)
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */
object ValidPerfectSquare {

    fun isPerfectSquare(num: Int): Boolean {
        fun isGoodApproximation(estimate: Double): Boolean =
            abs(estimate * estimate - num) / num < 1e-6

        // Newton's Method https://en.wikipedia.org/wiki/Newton%27s_method
        // x[n + 1] = x[n] - f(x[n]) / f'(x[n])
        // In our case: f(x) = x^2 - n
        var estimate = 1.0
        while (!isGoodApproximation(estimate)) {
            estimate = 0.5 * (estimate + num / estimate)
        }
        val root = estimate.roundToInt()
        return root * root == num
    }
}