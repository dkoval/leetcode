package com.github.dkoval.leetcode.challenge

import kotlin.random.Random
import kotlin.random.nextInt

/**
 * [Random Pick with Weight](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/)
 *
 * Given an array w of positive integers, where ```w[i]``` describes the weight of index `i`,
 * write a function `pickIndex` which randomly picks an index in proportion to its weight.
 */
class RandomPickWithWeight(w: IntArray) {
    private val cumulativeWeights = IntArray(w.size)

    init {
        var sum = 0
        for (i in w.indices) {
            sum += w[i]
            cumulativeWeights[i] = sum
        }
    }

    // Resource: https://www.youtube.com/watch?v=v-_aEMtgnkI
    fun pickIndex(): Int {
        val x = Random.nextInt(1..cumulativeWeights.last())
        return findIndex(x)
    }

    private fun findIndex(x: Int): Int {
        // since cumulativeWeights array is sorted,
        // binary search can be used here
        var l = 0
        var r = cumulativeWeights.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            if (cumulativeWeights[mid] < x) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return l
    }
}