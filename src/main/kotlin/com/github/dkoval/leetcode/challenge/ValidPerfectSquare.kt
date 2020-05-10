package com.github.dkoval.leetcode.challenge

/**
 * [Valid Perfect Square](https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/)
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */
object ValidPerfectSquare {

    fun isPerfectSquare(num: Int): Boolean {
        // Newton's Method modified for integer arithmetic
        var x1 = num
        var x2 = 1
        while (x1 > x2) {
            x1 = x2 + (x1 - x2) / 2 // prevents int overflow, is the same as (x1 + x2) / 2
            x2 = num / x1
        }
        return x1 == x2 && num % x1 == 0
    }
}