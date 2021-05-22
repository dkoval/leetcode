package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NQueensTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                1,
                listOf(
                    listOf("Q")
                )
            ),
            Arguments.of(
                4,
                listOf(
                    listOf(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                    ),
                    listOf(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                    )
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return all distinct solutions to the n-queens puzzle`(n: Int, expected: List<List<String>>) {
        val actual = NQueens().solveNQueens(n)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}