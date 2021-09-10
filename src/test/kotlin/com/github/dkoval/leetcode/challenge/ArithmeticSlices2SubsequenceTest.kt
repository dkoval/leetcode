package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ArithmeticSlices2SubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 4, 6, 8, 10),
                7
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7),
                16
            ),
            Arguments.of(
                intArrayOf(5, 3, 4, 5, 7, 9),
                5
            ),
            Arguments.of(
                intArrayOf(0, 2000000000, -294967296),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of all the arithmetic subsequences of nums`(nums: IntArray, expected: Int) {
        val actual = ArithmeticSlices2Subsequence().numberOfArithmeticSlices(nums)
        assertEquals(expected, actual)
    }
}