package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PartitionArrayIntoDisjointIntervalsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 0, 3, 8, 6),
                // Explanation: left = [5,0,3], right = [8,6]
                3
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 0, 6, 12),
                // Explanation: left = [1,1,1,0], right = [6,12]
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of left after such a partitioning`(nums: IntArray, expected: Int) {
        val actual = PartitionArrayIntoDisjointIntervals().partitionDisjoint(nums)
        assertEquals(expected, actual)
    }
}