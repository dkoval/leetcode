package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.ValidPerfectSquare
import kotlin.math.abs
import kotlin.math.roundToInt

object ValidPerfectSquareNewton : ValidPerfectSquare {

    override fun isPerfectSquare(num: Int): Boolean {
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