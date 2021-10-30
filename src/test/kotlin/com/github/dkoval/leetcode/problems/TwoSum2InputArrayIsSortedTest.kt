package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TwoSum2InputArrayIsSortedTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 7, 11, 15),
                9,
                intArrayOf(1, 2)
            ),
            Arguments.of(
                intArrayOf(2, 3, 4),
                6,
                intArrayOf(1, 3)
            ),
            Arguments.of(
                intArrayOf(-1, 0),
                -1,
                intArrayOf(1, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find indices of two numbers such that they add up to a specific target number`(
        nums: IntArray,
        target: Int,
        expected: IntArray
    ) {
        val actual = TwoSum2InputArrayIsSorted().twoSum(nums, target)
        assertArrayEquals(expected, actual)
    }
}