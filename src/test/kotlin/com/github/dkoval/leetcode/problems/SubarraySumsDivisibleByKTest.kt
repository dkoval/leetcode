package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SubarraySumsDivisibleByKTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // There are 7 subarrays with a sum divisible by K = 5:
            // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
            Arguments.of(
                intArrayOf(4, 5, 0, -2, -3, 1),
                5,
                7
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of (contiguous, non-empty) subarrays that have a sum divisible by K`(
        A: IntArray,
        K: Int,
        expected: Int
    ) {
        val actual = SubarraySumsDivisibleByK.subarraysDivByK(A, K)
        assertEquals(expected, actual)
    }
}