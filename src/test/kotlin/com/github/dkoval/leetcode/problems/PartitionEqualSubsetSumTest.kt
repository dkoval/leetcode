package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PartitionEqualSubsetSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 5, 11, 5),
                // The array can be partitioned as [1, 5, 5] and [11]
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 5),
                // The array cannot be partitioned into equal sum subsets
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal`(
        nums: IntArray, expected: Boolean
    ) {
        val actual = PartitionEqualSubsetSum.canPartition(nums)
        assertEquals(expected, actual)
    }
}