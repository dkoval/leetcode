package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumDistanceInArraysTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5),
                    listOf(1, 2, 3)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4),
                    listOf(0, 5)
                ),
                4
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4, 5),
                    listOf(0, 2)
                ),
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the maximum distance in arrays`(arrays: List<List<Int>>, expected: Int) {
        val actual = MaximumDistanceInArrays.maxDistance(arrays)
        assertEquals(expected, actual)
    }
}