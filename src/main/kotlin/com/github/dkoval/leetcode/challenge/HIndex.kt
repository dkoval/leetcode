package com.github.dkoval.leetcode.challenge

/**
 * [H-Index](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/)
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the [definition of h-index on Wikipedia](https://en.wikipedia.org/wiki/H-index):
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 */
interface HIndex {

    fun hIndex(citations: IntArray): Int
}

object HIndexNLongN : HIndex {

    override fun hIndex(citations: IntArray): Int {
        citations.sort()
        var i = 1
        while (i <= citations.size) {
            if (citations[citations.size - i] < i) break
            i++
        }
        return i - 1
    }
}

object HIndexLinear : HIndex {

    override fun hIndex(citations: IntArray): Int {
        val buckets = IntArray(citations.size + 1)
        for (citation in citations) {
            if (citation <= citations.size) {
                buckets[citation]++
            } else {
                buckets[buckets.lastIndex]++
            }
        }
        var result = 0
        for (i in buckets.lastIndex downTo 0) {
            result += buckets[i]
            if (result >= i) return i
        }
        return 0
    }
}