package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ReduceArraySizeToHalfTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7),
                2
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7, 7),
                1
            ),
            Arguments.of(
                intArrayOf(1, 9),
                1
            ),
            Arguments.of(
                intArrayOf(1000, 1000, 3, 7),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum size of the set so that at least half of the integers of the array are removed`(
        arr: IntArray,
        expected: Int
    ) {
        val actual = ReduceArraySizeToHalf().minSetSize(arr)
        assertEquals(expected, actual)
    }
}