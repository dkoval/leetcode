package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KthLargestElementInArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 2, 1, 5, 6, 4),
                2,
                5
            ),
            Arguments.of(
                intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6),
                4,
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the kth largest element in the array`(nums: IntArray, k: Int, expected: Int) {
        val actual = KthLargestElementInArray().findKthLargest(nums, k)
        assertEquals(expected, actual)
    }
}