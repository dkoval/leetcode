package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TwoSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 7, 11, 15),
                9,
                intArrayOf(0, 1)
            ),
            Arguments.of(
                intArrayOf(3, 2, 4),
                6,
                intArrayOf(1, 2)
            ),
            Arguments.of(
                intArrayOf(3, 3),
                6,
                intArrayOf(0, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return indices of the two numbers such that they add up to target`(
        nums: IntArray,
        target: Int,
        expected: IntArray
    ) {
        val actual = TwoSum().twoSum(nums, target)
        assertArrayEquals(expected, actual)
    }
}