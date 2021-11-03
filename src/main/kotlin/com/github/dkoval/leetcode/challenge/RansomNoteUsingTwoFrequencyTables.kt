package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.RansomNote

/**
 * [Ransom Note](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/)
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 */
object RansomNoteUsingTwoFrequencyTables : RansomNote {

    override fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val charOccurrencesInRansomNote = ransomNote.groupingBy { it }.eachCount()
        val charOccurrencesInMagazine = magazine.groupingBy { it }.eachCount()
        return charOccurrencesInRansomNote.entries.all { (ch, occurrencesInRansomNote) ->
            charOccurrencesInMagazine[ch]
                ?.let { occurrencesInMagazine -> occurrencesInMagazine >= occurrencesInRansomNote }
                ?: false
        }
    }
}