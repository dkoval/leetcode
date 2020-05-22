package com.github.dkoval.leetcode.challenge

/**
 * [Jewels and Stones](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/)
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
object JewelsAndStones {

    fun numJewelsInStones(J: String, S: String): Int {
        val jewels = J.toCharArray().toSet()
        return S.count { ch -> ch in jewels }
    }
}