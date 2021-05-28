package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumErasureValueTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 2, 4, 5, 6),
                17
            ),
            Arguments.of(
                intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5),
                8
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum score you can get by erasing exactly one subarray`(nums: IntArray, expected: Int) {
        val actual = MaximumErasureValue().maximumUniqueSubarray(nums)
        assertEquals(expected, actual)
    }
}