package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FloodFillTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1)
                ),
                1, 1, 2,
                arrayOf(
                    intArrayOf(2, 2, 2),
                    intArrayOf(2, 2, 0),
                    intArrayOf(2, 0, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1)
                ),
                1, 1, 1,
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should flood fill 4-directionally connected pixels with the newColor value`(
        image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, expected: Array<IntArray>
    ) {
        val actual = FloodFill.floodFill(image, sr, sc, newColor)
        assertArrayEquals(expected, actual)
    }
}