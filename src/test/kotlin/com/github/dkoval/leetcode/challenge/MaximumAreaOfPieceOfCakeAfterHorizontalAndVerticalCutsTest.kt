package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCutsTest {


    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                5,
                4,
                intArrayOf(1, 2, 4),
                intArrayOf(1, 3),
                4
            ),
            Arguments.of(
                5,
                4,
                intArrayOf(3, 1),
                intArrayOf(1),
                6
            ),
            Arguments.of(
                5,
                4,
                intArrayOf(3),
                intArrayOf(3),
                9
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum area of a piece of cake after you cut at each horizontal and vertical position`(
        h: Int,
        w: Int,
        horizontalCuts: IntArray,
        verticalCuts: IntArray,
        expected: Int
    ) {
        val actual =
            MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts().maxArea(h, w, horizontalCuts, verticalCuts)
        assertEquals(expected, actual)
    }
}