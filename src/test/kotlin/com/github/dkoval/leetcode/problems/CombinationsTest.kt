package com.github.dkoval.leetcode.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CombinationsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                4,
                2,
                listOf(
                    listOf(1, 2),
                    listOf(1, 3),
                    listOf(1, 4),
                    listOf(2, 3),
                    listOf(2, 4),
                    listOf(3, 4)
                )
            ),
            Arguments.of(
                1,
                1,
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                2,
                1,
                listOf(
                    listOf(1),
                    listOf(2)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possible combinations of k numbers out of the range (1, n)`(
        n: Int,
        k: Int,
        expected: List<List<Int>>
    ) {
        val actual = Combinations().combine(n, k)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}