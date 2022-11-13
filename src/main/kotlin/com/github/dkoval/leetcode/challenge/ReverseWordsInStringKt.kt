package com.github.dkoval.leetcode.challenge

import java.util.*

object ReverseWordsInStringKt : ReverseWordsInString {

    override fun reverseWords(s: String): String {
        val result: Deque<String> = ArrayDeque()
        var start = 0
        while (start < s.length) {
            // remove leading spaces from the current word
            while (start < s.length && s[start] == ' ') start++
            if (start >= s.length) break

            // find the ending index (exclusive) of the current word
            var end = start + 1
            while (end < s.length && s[end] != ' ') end++

            val word = s.substring(start, end)
            result.addFirst(word)

            // prepare for the next iteration
            start = end + 1
        }
        return result.joinToString(separator = " ")
    }
}