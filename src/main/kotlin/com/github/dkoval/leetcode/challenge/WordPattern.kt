package com.github.dkoval.leetcode.challenge

/**
 * [Word Pattern](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3451/)
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by
 * a single space.
 */
object WordPattern {

    fun wordPattern(pattern: String, str: String): Boolean {
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