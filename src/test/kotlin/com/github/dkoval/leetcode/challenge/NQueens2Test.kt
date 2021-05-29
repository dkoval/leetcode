package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NQueens2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 0),
            Arguments.of(3, 0),
            Arguments.of(4, 2),
            Arguments.of(5, 10)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of distinct solutions to the n-queens puzzle`(n: Int, expected: Int) {
        val actual = NQueens2().totalNQueens(n)
        assertEquals(expected, actual)
    }
}