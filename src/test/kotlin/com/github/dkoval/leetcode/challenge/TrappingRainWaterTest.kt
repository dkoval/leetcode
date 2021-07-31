package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TrappingRainWaterTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1),
                6
            ),
            Arguments.of(
                intArrayOf(4, 2, 0, 3, 2, 5),
                9
            ),
            Arguments.of(
                intArrayOf(),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute how much water can be trapped after raining`(heights: IntArray, expected: Int) {
        val actual = TrappingRainWater().trap(heights)
        assertEquals(expected, actual)
    }
}