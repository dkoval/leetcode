package com.github.dkoval.leetcode.challenge

/**
 * [Word Pattern](https://leetcode.com/problems/word-pattern/)
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by
 * a single space.
 *
 * Constraints:
 *
 * - 1 <= pattern.length <= 300
 * - pattern contains only lower-case English letters.
 * - 1 <= s.length <= 3000
 * - s contains only lowercase English letters and spaces `' '`.
 * - s does not contain any leading or trailing spaces.
 * - All the words in s are separated by a single space.
 */
interface WordPattern {
    fun wordPattern(pattern: String, str: String): Boolean
}

object WordPatternRev1 : WordPattern {

    override fun wordPattern(pattern: String, str: String): Boolean {
        val words = str.split(" ")
        if (pattern.length != words.size) {
            return false
        }

        val charToWord = mutableMapOf<Char, String>()
        val wordToChar = mutableMapOf<String, Char>()
        for (i in pattern.indices) {
            val c = pattern[i]
            val word = words[i]
            if (c in charToWord && charToWord[c] != word) {
                return false
            }
            if (word in wordToChar && wordToChar[word] != c) {
                return false
            }
            charToWord[c] = word
            wordToChar[word] = c
        }
        return true
    }
}

object WordPatternRev2 : WordPattern {

    override fun wordPattern(pattern: String, str: String): Boolean {
        val words = str.split(" ")
        if (pattern.length != words.size) {
            return false
        }

        val charToWord = mutableMapOf<Char, String>()
        val wordToChar = mutableMapOf<String, Char>()
        for (i in pattern.indices) {
            val c = pattern[i]
            val word = words[i]
            if (word != charToWord.getOrPut(c) { word } || c != wordToChar.getOrPut(word) { c }) {
                return false
            }
        }
        return true
    }
}