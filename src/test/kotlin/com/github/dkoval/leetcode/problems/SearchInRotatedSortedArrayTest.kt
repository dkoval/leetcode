package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInRotatedSortedArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                0,
                4
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                3,
                -1
            ),
            Arguments.of(
                intArrayOf(1),
                0,
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the index of target after the possible rotation of nums array`(
        nums: IntArray,
        target: Int,
        expected: Int
    ) {
        val actual = SearchInRotatedSortedArray().search(nums, target)
        assertEquals(expected, actual)
    }
}