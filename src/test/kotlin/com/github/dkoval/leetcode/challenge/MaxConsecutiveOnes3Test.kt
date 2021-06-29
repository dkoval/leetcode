package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class MaxConsecutiveOnes3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0),
                2,
                6
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1),
                3,
                10
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should the maximum number of consecutive 1's in the array if you can flip at most k 0's`(
        nums: IntArray,
        k: Int,
        expected: Int
    ) {
        val actual = MaxConsecutiveOnes3().longestOnes(nums, k)
        assertEquals(expected, actual)
    }
}