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
object DetectCapital {

    fun detectCapitalUse(word: String): Boolean {
        if (word.length == 1) return true
        return if (word[0].isUpperCase()) {
            var prevLetterIsUppercase = true
            for (i in 1 until word.length) {
                val currLetterIsUppercase = word[i].isUpperCase()
                if (currLetterIsUppercase && !prevLetterIsUppercase) return false
                if (i > 1 && !currLetterIsUppercase && prevLetterIsUppercase) return false
                prevLetterIsUppercase = currLetterIsUppercase
            }
            true
        } else {
            for (i in 1 until word.length) {
                if (!word[i].isLowerCase()) return false
            }
            true
        }
    }
}