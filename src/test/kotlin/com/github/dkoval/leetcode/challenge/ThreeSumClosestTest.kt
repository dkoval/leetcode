package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ThreeSumClosestTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(-1, 2, 1, -4),
                1,
                2
            ),
            Arguments.of(
                intArrayOf(0, 2, 1, -3),
                1,
                0
            ),
            Arguments.of(
                intArrayOf(1, 1, -1, -1, 3),
                -1,
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find three integers in nums such that the sum is closest to target`(
        nums: IntArray,
        target: Int,
        expected: Int
    ) {
        val actual = ThreeSumClosest().threeSumClosest(nums, target)
        assertEquals(expected, actual)
    }
}