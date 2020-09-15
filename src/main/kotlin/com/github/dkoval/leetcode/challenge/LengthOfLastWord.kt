package com.github.dkoval.leetcode.challenge

/**
 * [Length of Last Word](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/)
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 */
object LengthOfLastWord {

    fun lengthOfLastWord(s: String): Int {
        var result = 0
        var end = s.lastIndex
        for (i in s.lastIndex downTo 0) {
            if (s[i] == ' ' && i == end) {
                // ignore tailing whitespaces
                end--
            } else if (s[i] != ' ') {
                // count letters
                result++
            } else {
                break
            }
        }
        return result
    }
}