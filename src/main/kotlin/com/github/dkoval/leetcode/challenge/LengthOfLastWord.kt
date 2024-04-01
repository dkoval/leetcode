package com.github.dkoval.leetcode.challenge

object LengthOfLastWordRev1 : LengthOfLastWord {

    override fun lengthOfLastWord(s: String): Int {
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

object LengthOfLastWordRev2 : LengthOfLastWord {

    override fun lengthOfLastWord(s: String): Int {
        var end = s.length - 1
        // ignore tailing whitespaces
        while (end >= 0 && s[end] == ' ') end--
        if (end < 0) return 0
        var start = end
        // count letters
        while (start >= 0 && s[start] != ' ') start--
        return end - start
    }
}