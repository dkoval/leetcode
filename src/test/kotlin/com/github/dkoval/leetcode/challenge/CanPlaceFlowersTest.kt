package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CanPlaceFlowersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 0, 0, 0, 1),
                1,
                true
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 0, 1),
                2,
                false
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 0, 0, 1),
                2,
                false
            ),
            Arguments.of(
                intArrayOf(0, 1, 0),
                1,
                false
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 0, 1),
                1,
                true
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0, 1, 0, 0),
                0,
                true
            ),
            Arguments.of(
                intArrayOf(1, 0, 1, 0, 1, 0, 1),
                0,
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule`(
        flowerbed: IntArray,
        n: Int,
        expected: Boolean
    ) {
        val actual = CanPlaceFlowers().canPlaceFlowers(flowerbed, n)
        assertEquals(expected, actual)
    }
}