package com.github.dkoval.leetcode.problems

/**
 * [Shortest Way To Form String](https://leetcode.com/problems/shortest-way-to-form-string/)
 *
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 *
 * Given two strings source and target, return the minimum number of subsequences of source such that
 * their concatenation equals target. If the task is impossible, return -1.
 */
interface ShortestWayToFormString {

    fun shortestWay(source: String, target: String): Int
}

// Time complexity: O(M*N), space complexity O(1)
object ShortestWayToFormStringInMNTime : ShortestWayToFormString {

    override fun shortestWay(source: String, target: String): Int {
        var result = 0
        var t = 0
        while (t < target.length) {
            val wanted = t
            for (s in source.indices) {
                if (t < target.length && target[t] == source[s]) {
                    t++
                }
            }
            if (wanted == t) return -1
            result++
        }
        return result
    }
}