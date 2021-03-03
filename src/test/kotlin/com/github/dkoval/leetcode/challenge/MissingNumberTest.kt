package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MissingNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1),
                8
            ),
            Arguments.of(
                intArrayOf(0),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return number in the range that is missing`(nums: IntArray, expected: Int) {
        val actual = MissingNumber().missingNumber(nums)
        assertEquals(expected, actual)
    }
}