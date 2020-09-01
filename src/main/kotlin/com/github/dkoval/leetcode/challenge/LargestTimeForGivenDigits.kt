package com.github.dkoval.leetcode.challenge

/**
 * [Largest Time for Given Digits](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/)
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 */
object LargestTimeForGivenDigits {

    fun largestTimeFromDigits(A: IntArray): String {
        var result = ""
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                for (k in 0 until 4) {
                    // generate all possible combinations of hh:mm string and then take the largest
                    if (i == j || j == k || i == k) continue
                    val hh = A[i].toString() + A[j].toString()
                    if (hh >= "24") continue
                    val mm = A[k].toString() + A[6 - i - j - k].toString()
                    if (mm >= "60") continue
                    val time = "$hh:$mm"
                    if (time > result) {
                        result = time
                    }
                }
            }
        }
        return result
    }
}