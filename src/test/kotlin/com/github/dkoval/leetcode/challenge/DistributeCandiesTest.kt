package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DistributeCandiesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 3, 3),
                3
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3),
                2
            ),
            Arguments.of(
                intArrayOf(6, 6, 6, 6),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of different types of candies`(candyType: IntArray, expected: Int) {
        val actual = DistributeCandies().distributeCandies(candyType)
        assertEquals(expected, actual)
    }
}