package com.github.dkoval.leetcode.interview.strings

/**
 * [Valid Palindrome](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/)
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
object ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while (i < j && !s[i].isLetterOrDigit()) {
                i++
            }
            while (i < j && !s[j].isLetterOrDigit()) {
                j--
            }
            if (!s[i].equals(s[j], ignoreCase = true)) {
                return false
            }
            i++
            j--
        }

        return true
    }
}