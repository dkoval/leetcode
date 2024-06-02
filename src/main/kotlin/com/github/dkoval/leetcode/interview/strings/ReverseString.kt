package com.github.dkoval.leetcode.interview.strings

import com.github.dkoval.leetcode.challenge.ReverseString

object ReverseStringRev1 : ReverseString {

    override fun reverseString(s: CharArray) {
        val n = s.size
        for (i in 0 until n / 2) {
            val tmp = s[i]
            s[i] = s[n - i - 1]
            s[n - i - 1] = tmp
        }
    }
}