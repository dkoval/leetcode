package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ArrayOfDoubledPairsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 1, 3, 6),
                false
            ),
            Arguments.of(
                intArrayOf(2, 1, 2, 6),
                false
            ),
            Arguments.of(
                intArrayOf(4, -2, 2, -4),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 16, 8, 4),
                false
            ),
            Arguments.of(
                intArrayOf(),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if it is possible to reorder arr such that arr(2 x i + 1) = 2 x arr(2 x i)`(
        arr: IntArray,
        expected: Boolean
    ) {
        val actual = ArrayOfDoubledPairs().canReorderDoubled(arr)
        assertEquals(expected, actual)
    }
}