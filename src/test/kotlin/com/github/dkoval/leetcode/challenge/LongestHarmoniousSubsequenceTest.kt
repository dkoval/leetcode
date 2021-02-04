package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestHarmoniousSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3, 2, 2, 5, 2, 3, 7),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                2
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the longest harmonious subsequence`(nums: IntArray, expected: Int) {
        val actual = LongestHarmoniousSubsequence().findLHS(nums)
        assertEquals(expected, actual)
    }
}