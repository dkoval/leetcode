package com.github.dkoval.leetcode.interview.array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PlusOneTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
            Arguments.of(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
            Arguments.of(intArrayOf(1, 2, 9, 9), intArrayOf(1, 3, 0, 0)),
            Arguments.of(intArrayOf(9), intArrayOf(1, 0)),
            Arguments.of(intArrayOf(9, 9), intArrayOf(1, 0, 0)),
            Arguments.of(intArrayOf(9, 9, 9), intArrayOf(1, 0, 0, 0))
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute plus one to the integer`(digits: IntArray, expected: IntArray) {
        val actual = PlusOne.plusOne(digits)
        assertArrayEquals(expected, actual)
    }
}