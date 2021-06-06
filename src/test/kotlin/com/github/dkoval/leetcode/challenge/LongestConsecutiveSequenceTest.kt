package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestConsecutiveSequenceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(100, 4, 200, 1, 3, 2),
                4
            ),
            Arguments.of(
                intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
                9
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `return the length of the longest consecutive elements sequence`(nums: IntArray, expected: Int) {
        val actual = LongestConsecutiveSequence().longestConsecutive(nums)
        assertEquals(expected, actual)
    }
}