package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ArithmeticSlicesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3, 5, 7, 9),
                6
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7),
                3
            ),
            Arguments.of(
                intArrayOf(3, -1, -5, -9),
                3
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 5, 7),
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of arithmetic slices in the array A`(A: IntArray, expected: Int) {
        val actual = ArithmeticSlices().numberOfArithmeticSlices(A)
        assertEquals(expected, actual)
    }
}