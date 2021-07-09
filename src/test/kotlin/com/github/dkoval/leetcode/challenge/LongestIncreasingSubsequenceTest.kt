package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestIncreasingSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(10, 9, 2, 5, 3, 7, 101, 18),
                4
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 3, 2, 3),
                4
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7, 7, 7),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the longest strictly increasing subsequence`(nums: IntArray, expected: Int) {
        val actual = LongestIncreasingSubsequence().lengthOfLIS(nums)
        assertEquals(expected, actual)
    }
}