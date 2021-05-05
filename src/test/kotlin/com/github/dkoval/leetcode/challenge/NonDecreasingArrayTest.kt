package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NonDecreasingArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(4, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(-1, 4, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(3, 4, 2, 3),
                false
            ),
            Arguments.of(
                intArrayOf(5, 7, 1, 8),
                true
            ),
            Arguments.of(
                intArrayOf(1, 4, 1, 2),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if nums array could become non-decreasing by modifying at most one element`(
        nums: IntArray,
        expected: Boolean
    ) {
        val actual = NonDecreasingArray().checkPossibility(nums)
        assertEquals(expected, actual)
    }
}