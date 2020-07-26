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