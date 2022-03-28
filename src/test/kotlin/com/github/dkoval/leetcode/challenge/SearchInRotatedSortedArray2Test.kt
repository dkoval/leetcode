package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInRotatedSortedArray2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 5, 6, 0, 0, 1, 2),
                0,
                true
            ),
            Arguments.of(
                intArrayOf(2, 5, 6, 0, 0, 1, 2),
                3,
                false
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 3, 2, 2, 2),
                3,
                true
            ),
            Arguments.of(
                intArrayOf(3, 1),
                1,
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should search in rotated sorted array with duplicates`(nums: IntArray, target: Int, expected: Boolean) {
        val actual = SearchInRotatedSortedArray2().search(nums, target)
        assertEquals(expected, actual)
    }
}