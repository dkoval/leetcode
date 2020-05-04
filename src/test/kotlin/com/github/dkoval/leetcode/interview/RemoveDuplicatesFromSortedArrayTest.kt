package com.github.dkoval.leetcode.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveDuplicatesFromSortedArrayTest {

    companion object {
        @JvmStatic
        fun input() = listOf<Arguments>(
            Arguments.of(intArrayOf(), intArrayOf(), 0),
            Arguments.of(intArrayOf(1, 1, 2), intArrayOf(1, 2), 2),
            Arguments.of(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), intArrayOf(0, 1, 2, 3, 4), 5)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove duplicated from a sorted array and return the new length`(
        nums: IntArray,
        expectedUniqueNums: IntArray,
        expectedLength: Int
    ) {
        val actualLength = RemoveDuplicatesFromSortedArray.removeDuplicates(nums)
        assertEquals(expectedLength, actualLength)

        val actualUniqueNums = nums.take(expectedLength).toIntArray()
        assertArrayEquals(expectedUniqueNums, actualUniqueNums)
    }
}