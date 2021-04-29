package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 7, 7, 8, 8, 10),
                8,
                intArrayOf(3, 4)
            ),
            Arguments.of(
                intArrayOf(5, 7, 7, 8, 8, 10),
                6,
                intArrayOf(-1, -1)
            ),
            Arguments.of(
                intArrayOf(),
                0,
                intArrayOf(-1, -1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find first and last position of element in sorted array`(
        nums: IntArray,
        target: Int,
        expected: IntArray
    ) {
        val actual = FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }
}