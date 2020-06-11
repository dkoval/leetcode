package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SortColorsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 0, 2, 1, 1, 0),
                intArrayOf(0, 0, 1, 1, 2, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should sort colors`(nums: IntArray, expected: IntArray) {
        SortColors.sortColors(nums)
        assertArrayEquals(expected, nums)
    }
}