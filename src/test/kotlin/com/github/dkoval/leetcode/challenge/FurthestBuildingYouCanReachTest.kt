package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FurthestBuildingYouCanReachTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 2, 7, 6, 9, 14, 12),
                5,
                1,
                4
            ),
            Arguments.of(
                intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19),
                10,
                2,
                7
            ),
            Arguments.of(
                intArrayOf(14, 3, 19, 3),
                17,
                0,
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally`(
        heights: IntArray,
        bricks: Int,
        ladders: Int,
        expected: Int
    ) {
        val actual = FurthestBuildingYouCanReach().furthestBuilding(heights, bricks, ladders)
        assertEquals(expected, actual)
    }
}