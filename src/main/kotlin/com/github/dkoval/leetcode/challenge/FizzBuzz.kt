package com.github.dkoval.leetcode.challenge

/**
 * [Fizz Buzz](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/)
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
object FizzBuzz {

    fun fizzBuzz(n: Int): List<String> = (1..n).map { doFizzBuzz(it) }

    private fun doFizzBuzz(n: Int): String = when {
        n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n.toString()
    }
}