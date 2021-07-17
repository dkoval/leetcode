package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ThreeEqualPartsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(0, 3)
            ),
            Arguments.of(
                intArrayOf(1, 1, 0, 1, 1),
                intArrayOf(-1, -1)
            ),
            Arguments.of(
                intArrayOf(1, 1, 0, 0, 1),
                intArrayOf(0, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should divide the array into three non-empty parts such that all of these parts represent the same binary value`(
        arr: IntArray,
        expected: IntArray
    ) {
        val actual = ThreeEqualParts().threeEqualParts(arr)
        assertArrayEquals(expected, actual)
    }
}