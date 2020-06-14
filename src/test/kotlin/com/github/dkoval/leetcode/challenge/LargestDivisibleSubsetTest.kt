package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LargestDivisibleSubsetTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 2, 3), listOf(1, 2)),
            Arguments.of(intArrayOf(1, 2, 4, 8), listOf(1, 2, 4, 8))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the largest divisible subset`(nums: IntArray, expected: List<Int>) {
        val actual = LargestDivisibleSubset.largestDivisibleSubset(nums)
        assertEquals(expected, actual)
    }
}