package com.github.dkoval.leetcode.challenge

object SortCharactersByFrequencyKt : SortCharactersByFrequency {

    override fun frequencySort(s: String): String {
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