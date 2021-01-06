package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KthMissingPositiveNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 3, 4, 7, 11),
                5,
                9
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                2,
                6
            ),
            Arguments.of(
                intArrayOf(2, 3, 4),
                4,
                7
            ),
            Arguments.of(
                intArrayOf(5),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(1),
                3,
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the kth positive integer that is missing in the array`(arr: IntArray, k: Int, expected: Int) {
        val actual = KthMissingPositiveNumber().findKthPositive(arr, k)
        assertEquals(expected, actual)
    }
}