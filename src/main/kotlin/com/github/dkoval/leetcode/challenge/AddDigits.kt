package com.github.dkoval.leetcode.challenge

object AddDigitsConstantTime : AddDigits {

    // Resources:
    // https://en.wikipedia.org/wiki/Digital_root
    // https://www.youtube.com/watch?v=tIjdI-ioXh0
    override fun addDigits(num: Int): Int = when {
        num == 0 -> 0
        num % 9 == 0 -> 9
        else -> num % 9
    }
}