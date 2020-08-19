package com.github.dkoval.leetcode.challenge

/**
 * [Goat Latin](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/)
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin).
 *
 * The rules of Goat Latin are as follows:
 * - If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * - If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * - Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 *
 * Return the final sentence representing the conversion from S to Goat Latin.
 */
object GoatLatin {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun toGoatLatin(S: String): String {
        val words = S.split("\\s".toRegex())
        val result = StringBuilder()
        words.forEachIndexed { index, word ->
            if (word.first().toLowerCase() in vowels) {
                result.append(word)
            } else {
                result.append(word.substring(1))
                result.append(word.first())
            }
            result.append("ma")
            repeat(index + 1) { result.append('a') }
            if (index >= 0 && index < words.lastIndex) {
                result.append(' ')
            }
        }
        return result.toString()
    }
}