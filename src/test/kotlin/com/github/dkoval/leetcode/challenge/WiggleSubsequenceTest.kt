package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WiggleSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 7, 4, 9, 2, 5),
                6
            ),
            Arguments.of(
                intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8),
                7
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                2
            ),
            Arguments.of(
                intArrayOf(0, 0),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the longest wiggle sequence`(nums: IntArray, expected: Int) {
        val actual = WiggleSubsequence().wiggleMaxLength(nums)
        assertEquals(expected, actual)
    }
}