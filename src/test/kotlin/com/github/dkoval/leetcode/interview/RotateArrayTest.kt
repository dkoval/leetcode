package com.github.dkoval.leetcode.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RotateArrayTest {

    companion object {
        @JvmStatic
        fun input() = listOf<Arguments>(
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3, intArrayOf(5, 6, 7, 1, 2, 3, 4)),
            Arguments.of(intArrayOf(-1, -100, 3, 99), 2, intArrayOf(3, 99, -1, -100))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should rotate the array to the right by k steps`(nums: IntArray, k: Int, output: IntArray) {
        RotateArray.rotate(nums, k)
        assertArrayEquals(output, nums)
    }
}