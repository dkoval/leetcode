package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class NumberOfLongestIncreasingSubsequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3, 5, 4, 7),
                // The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7]
                2
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                // The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return return the number of longest increasing subsequences`(nums: IntArray, expected: Int) {
        val actual = NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums)
        assertEquals(expected, actual)
    }
}