package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PascalTriangle2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                0,
                listOf(1)
            ),
            Arguments.of(
                1,
                listOf(1, 1)
            ),
            Arguments.of(
                2,
                listOf(1, 2, 1)
            ),
            Arguments.of(
                3,
                listOf(1, 3, 3, 1)
            ),
            Arguments.of(
                4,
                listOf(1, 4, 6, 4, 1)
            ),
            Arguments.of(
                5,
                listOf(1, 5, 10, 10, 5, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the kth index row of the Pascal's triangle`(rowIndex: Int, expected: List<Int>) {
        val actual = PascalTriangle2.getRow(rowIndex)
        assertEquals(expected, actual)
    }
}