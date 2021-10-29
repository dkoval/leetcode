package com.github.dkoval.leetcode.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CombinationSum2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(10, 1, 2, 7, 6, 1, 5),
                8,
                listOf(
                    listOf(1, 1, 6),
                    listOf(1, 2, 5),
                    listOf(1, 7),
                    listOf(2, 6)
                )
            ),
            Arguments.of(
                intArrayOf(2, 5, 2, 1, 2),
                5,
                listOf(
                    listOf(1, 2, 2),
                    listOf(5)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all unique combinations in candidates where the candidate numbers sum to target`(
        candidates: IntArray,
        target: Int,
        expected: List<List<Int>>
    ) {
        val actual = CombinationSum2().combinationSum2(candidates, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}