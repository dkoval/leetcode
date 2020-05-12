package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MoveZerosTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(0, 1, 0, 3, 12), intArrayOf(1, 3, 12, 0, 0))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should move all 0's to the end of it while maintaining the relative order of the non-zero elements`(
        nums: IntArray,
        expected: IntArray
    ) {
        MoveZeros.moveZeroes(nums)
        assertArrayEquals(expected, nums)
    }
}