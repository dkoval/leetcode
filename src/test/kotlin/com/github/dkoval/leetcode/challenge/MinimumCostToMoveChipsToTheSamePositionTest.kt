package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumCostToMoveChipsToTheSamePositionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3),
                1
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 3, 3),
                2
            ),
            Arguments.of(
                intArrayOf(1, 1000000000),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum cost needed to move all the chips to the same position`(
        positions: IntArray,
        expected: Int
    ) {
    }
}