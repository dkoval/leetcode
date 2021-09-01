package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ArrayNestingTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 4, 0, 3, 1, 6, 2),
                4
            ),
            Arguments.of(
                intArrayOf(0, 1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(0),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the longest length of a set s(k)`(nums: IntArray, expected: Int) {
        val actual = ArrayNesting().arrayNesting(nums)
        assertEquals(expected, actual)
    }
}