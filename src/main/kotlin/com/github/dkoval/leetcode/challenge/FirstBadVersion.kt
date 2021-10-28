package com.github.dkoval.leetcode.challenge

/**
 * [First Bad Version](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/)
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find
 * the first bad version. You should minimize the number of calls to the API.
 */
class FirstBadVersion(private val isBadVersion: (Int) -> Boolean) {

    fun firstBadVersion(n: Int) : Int {
        var l = 1
        var r = n
        while (l < r) {
            val mid = l + (r - l) / 2
            val bad = isBadVersion(mid)
            if (bad) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }
}