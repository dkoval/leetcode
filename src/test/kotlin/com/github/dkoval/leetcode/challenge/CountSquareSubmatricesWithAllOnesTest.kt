package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountSquareSubmatricesWithAllOnesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(0, 1, 1, 1)
                ),
                15
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                7
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count square submatrices with all ones`(matrix: Array<IntArray>, expected: Int) {
        val actual = CountSquareSubmatricesWithAllOnes.countSquares(matrix)
        assertEquals(expected, actual)
    }
}