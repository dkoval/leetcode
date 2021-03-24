package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AdvantageShuffleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 7, 11, 15),
                intArrayOf(1, 10, 4, 11),
                intArrayOf(2, 11, 7, 15)
            ),
            Arguments.of(
                intArrayOf(12, 24, 8, 32),
                intArrayOf(13, 25, 32, 11),
                intArrayOf(24, 32, 8, 12)
            ),
            Arguments.of(
                intArrayOf(2, 0, 4, 1, 2),
                intArrayOf(1, 3, 0, 0, 2),
                intArrayOf(2, 0, 1, 2, 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return any permutation of A that maximizes its advantage with respect to B`(
        A: IntArray,
        B: IntArray,
        expected: IntArray
    ) {
        val actual = AdvantageShuffle().advantageCount(A, B)
        assertArrayEquals(expected, actual)
    }
}