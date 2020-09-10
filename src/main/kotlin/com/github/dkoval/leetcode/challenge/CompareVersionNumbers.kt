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
        val tokens1 = version1.split(".")
        val tokens2 = version2.split(".")
        val maxLength = maxOf(tokens1.size, tokens2.size)
        for (i in 0 until maxLength) {
            val v1 = if (i < tokens1.size) tokens1[i].toInt() else 0
            val v2 = if (i < tokens2.size) tokens2[i].toInt() else 0
            if (v1 < v2)
                return -1
            else if (v1 > v2)
                return 1
        }
        return 0
    }
}