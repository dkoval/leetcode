package com.github.dkoval.leetcode.challenge

/**
 * [H-Index II](https://leetcode.com/problems/h-index-ii/)
 *
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the [definition of h-index on Wikipedia](https://en.wikipedia.org/wiki/H-index):
 * "A scientist has index h if h of his/her N papers have at least h citations each, and
 * the other N − h papers have no more than h citations each."
 *
 * Constraints:
 * - ```n == citations.length```
 * - ```1 <= n <= 10^5```
 * - ```0 <= citations[i] <= 1000```
 * citations is sorted in ascending order
 */
interface HIndex2 {

    fun hIndex(citations: IntArray): Int
}

object HIndex2Linear : HIndex2 {

    override fun hIndex(citations: IntArray): Int {
        val n = citations.size
        var i = citations.lastIndex
        while (i >= 0) {
            if (citations[i] < n - i) {
                // n - i stands for the number of elements to the right,
                // which are >= citations[i]
                break
            }
            i--
        }
        return n - i - 1
    }
}

object HIndex2BinarySearch : HIndex2 {

    override fun hIndex(citations: IntArray): Int {
        val n = citations.size
        var l = 0
        var r = citations.lastIndex
        /*while (l <= r) {
            val m = l + (r - l) / 2
            if (citations[m] < n - m) {
                l = m + 1
            } else {
                r = m - 1
            }
        }*/

        while (l <= r) {
            val m = l + (r - l) / 2
            when {
                citations[m] == n - m -> {
                    return citations[m]
                }
                citations[m] < n - m -> {
                    l = m + 1
                }
                else -> {
                    r = m - 1
                }
            }
        }
        return n - l
    }
}