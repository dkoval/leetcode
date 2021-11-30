package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximalRectangleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
                ),
                6
            ),
            Arguments.of(
                arrayOf<CharArray>(),
                0
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0')
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('1')
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0'),
                    charArrayOf('0')
                ),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `find the largest rectangle containing only 1's and return its area`(matrix: Array<CharArray>, expected: Int) {
        val actual = MaximalRectangle().maximalRectangle(matrix)
        assertEquals(expected, actual)
    }
}