package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.FindTheTownJudge

object FindTheTownJudgeByComputingTrustTable : FindTheTownJudge {

    override fun findJudge(N: Int, trust: Array<IntArray>): Int {
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