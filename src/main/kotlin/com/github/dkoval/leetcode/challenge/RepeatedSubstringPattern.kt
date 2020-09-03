package com.github.dkoval.leetcode.challenge

/**
 * [Repeated Substring Pattern](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/)
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of
 * the substring together.
 *
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */
interface RepeatedSubstringPattern {

    fun repeatedSubstringPattern(s: String): Boolean
}

// Time complexity: O(N^2)
object RepeatedSubstringPatternStraightForward : RepeatedSubstringPattern {

    override fun repeatedSubstringPattern(s: String): Boolean {
        // try all pattern lengths, starting from s.length / 2 .. 1
        // as the minimum number of repeats of a pattern is 2
        for (patternLength in s.length / 2 downTo 1) {
            if (s.length % patternLength != 0) continue
            var i = 0
            while (i + patternLength < s.length && s[i] == s[i + patternLength]) {
                i++
            }
            if (i + patternLength == s.length) return true
        }
        return false
    }
}

object RepeatedSubstringPatternRegex : RepeatedSubstringPattern {

    override fun repeatedSubstringPattern(s: String): Boolean =
        s.matches("^([a-z]+)\\1+$".toRegex())
}