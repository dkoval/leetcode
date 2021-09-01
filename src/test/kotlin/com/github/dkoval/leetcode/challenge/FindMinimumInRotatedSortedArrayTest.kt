package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindMinimumInRotatedSortedArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 4, 5, 1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                0
            ),
            Arguments.of(
                intArrayOf(11, 13, 15, 17),
                11
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                1
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 5, 1),
                1
            ),
            Arguments.of(
                intArrayOf(4, 5, 1, 2, 3),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the minimum element in rotated sorted array with no duplicates allowed`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = FindMinimumInRotatedSortedArray.findMin(nums)
        assertEquals(expected, actual)
    }
}