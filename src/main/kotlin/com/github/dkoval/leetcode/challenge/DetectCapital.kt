package com.github.dkoval.leetcode.challenge

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * - All letters in this word are capitals, like "USA".
 * - All letters in this word are not capitals, like "leetcode".
 * - Only the first letter in this word is capital, like "Google".
 * - Otherwise, we define that this word doesn't use capitals in a right way.
 */
interface DetectCapital {
    fun detectCapitalUse(word: String): Boolean
}

object DetectCapitalRev1 : DetectCapital {

    override fun detectCapitalUse(word: String): Boolean {
        if (word.length == 1) return true
        if (word[0].isUpperCase() && word[1].isUpperCase()) {
            for (i in 2 until word.length) {
                if (word[i].isLowerCase()) return false
            }
        } else {
            for (i in 1 until word.length) {
                if (word[i].isUpperCase()) return false
            }
        }
        return true
    }
}

object DetectCapitalRev2 : DetectCapital {

    override fun detectCapitalUse(word: String): Boolean {
        val n = word.length

        // check word[1:] substring
        var allUpperCase = true
        var allLowerCase = true
        for (i in 1 until n) {
            if (word[i].isUpperCase()) {
                allLowerCase = false
            } else {
                allUpperCase = false
            }
        }

        val firstIsUpperCase: Boolean = word[0].isUpperCase()
        return firstIsUpperCase && (allUpperCase || allLowerCase) || allLowerCase
    }
}