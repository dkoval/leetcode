package com.github.dkoval.leetcode.challenge

/**
 * [Sort Characters By Frequency](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/)
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
object SortCharactersByFrequency {

    fun frequencySort(s: String): String {
        val frequencies = s.groupingBy { it }.eachCount()
        val sortedByFrequency = frequencies.entries.sortedByDescending { (_, frequency) -> frequency }
        val result = StringBuilder()
        for ((ch, frequency) in sortedByFrequency) {
            repeat(frequency) {
                result.append(ch)
            }
        }
        return result.toString()
    }
}