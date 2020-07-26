package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindMinimumInRotatedSortedArray2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 3, 5),
                1
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 0, 1),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the minimum element in rotated sorted array with duplicates allowed`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = FindMinimumInRotatedSortedArray2.findMin(nums)
        assertEquals(expected, actual)
    }
}