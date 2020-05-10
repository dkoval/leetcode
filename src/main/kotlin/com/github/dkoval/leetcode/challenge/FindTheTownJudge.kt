package com.github.dkoval.leetcode.challenge

/**
 * [Find the Town Judge](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/)
 *
 * In a town, there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 * - The town judge trusts nobody.
 * - Everybody (except for the town judge) trusts the town judge.
 * - There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given trust, an array of pairs ```trust[i] = [a, b]``` representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge. Otherwise, return -1.
 */
object FindTheTownJudge {

    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val trustTable = buildTrustTable(trust)
        if (trustTable.keys.size == N - 1) {
            val looksLikeJudge = looksLikeJudge(trustTable.keys, N)
            if (allTrustTo(trustTable.values, looksLikeJudge)) {
                return looksLikeJudge
            }
        }
        return -1
    }

    private fun buildTrustTable(trust: Array<IntArray>): Map<Int, Set<Int>> {
        val result = mutableMapOf<Int, MutableSet<Int>>()
        for ((a, b) in trust) {
            result.getOrPut(a) { mutableSetOf() }.add(b)
        }
        return result
    }

    private fun looksLikeJudge(trustOthers: Collection<Int>, N: Int): Int {
        fun sumNFirstNaturalNumbers(): Int =
            // sum of first N natural numbers: N * (N + 1) / 2
            if (N % 2 == 0) N / 2 * (N + 1)
            else (N + 1) / 2 * N

        return sumNFirstNaturalNumbers() - trustOthers.sum()
    }

    private fun allTrustTo(trustedByOthers: Collection<Set<Int>>, whoToTrust: Int): Boolean =
        trustedByOthers.all { whoToTrust in it }
}