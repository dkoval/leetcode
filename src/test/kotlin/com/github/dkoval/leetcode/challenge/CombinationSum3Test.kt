package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CombinationSum3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                3,
                7,
                listOf(
                    listOf(1, 2, 4)
                )
            ),
            Arguments.of(
                3,
                9,
                listOf(
                    listOf(1, 2, 6),
                    listOf(1, 3, 5),
                    listOf(2, 3, 4)
                )
            ),
            Arguments.of(
                4,
                1,
                emptyList<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all possible combinations of k numbers that add up to a number n`(
        k: Int,
        n: Int,
        expected: List<List<Int>>
    ) {
        val actual = CombinationSum3.combinationSum3(k, n)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}