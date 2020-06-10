package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInsertPositionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 3, 5, 6), 5, 2),
            Arguments.of(intArrayOf(1, 3, 5, 6), 2, 1),
            Arguments.of(intArrayOf(1, 3, 5, 6), 7, 4),
            Arguments.of(intArrayOf(1, 3, 5, 6), 0, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return insert position`(nums: IntArray, target: Int, expected: Int) {
        val actual = SearchInsertPosition.searchInsert(nums, target)
        assertEquals(expected, actual)
    }
}