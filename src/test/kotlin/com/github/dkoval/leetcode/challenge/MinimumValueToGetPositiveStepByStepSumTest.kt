package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumValueToGetPositiveStepByStepSumTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(-3, 2, -3, 4, 2),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(1, -2, -3),
                5
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should the minimum positive value of startValue such that the step by step sum is never less than 1`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = MinimumValueToGetPositiveStepByStepSum().minStartValue(nums)
        assertEquals(expected, actual)
    }
}