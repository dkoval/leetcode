package com.github.dkoval.leetcode.challenge

/**
 * [Hamming Distance](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/)
 * The []Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between two integers is the number of positions
 * at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 */
object HammingDistance {

    fun hammingDistance(x: Int, y: Int): Int {
        val bits = x xor y
        var count = 0
        for (i in 0..31) {
            count += (bits shr i) and 1
        }
        return count
    }
}