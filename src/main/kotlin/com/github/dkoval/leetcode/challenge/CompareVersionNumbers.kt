package com.github.dkoval.leetcode.challenge

/**
 * [Compare Version Numbers](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/)
 *
 * Compare two version numbers version1 and version2
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
 * Its third and fourth level revision number are both 0.
 *
 * Note:
 * - Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
 * - Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
object CompareVersionNumbers {

    fun compareVersion(version1: String, version2: String): Int {
        fun levelRevisions(version: String): List<Int> = version.split(".").map { it.toInt() }

        val revs1 = levelRevisions(version1)
        val revs2 = levelRevisions(version2)

        val numCommonLevels = minOf(revs1.size, revs2.size)
        for (level in 0 until numCommonLevels) {
            val rev1 = revs1[level]
            val rev2 = revs2[level]
            if (rev1 < rev2) return -1
            if (rev1 > rev2) return 1
        }

        val longerRevs = if (revs1.size > revs2.size) revs1 else revs2
        for (level in numCommonLevels until longerRevs.size) {
            if (longerRevs[level] > 0) {
                return if (longerRevs == revs1) 1 else -1
            }
        }
        return 0
    }
}