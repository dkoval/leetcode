package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Reverse Words in a String](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/)
 *
 * Given an input string, reverse the string word by word.
 *
 * Note:
 * - A word is defined as a sequence of non-space characters.
 * - Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * - You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
object ReverseWordsInStringKt : ReverseWordsInString {

    override fun reverseWords(s: String): String {
        val result = LinkedList<String>()
        var i = 0
        while (i < s.length) {
            while (i < s.length && s[i] == ' ') i++
            if (i >= s.length) break
            var j = i + 1
            while (j < s.length && s[j] != ' ') j++
            val word = s.substring(i, j)
            result.addFirst(word)
            i = j + 1
        }
        return result.joinToString(separator = " ")
    }
}