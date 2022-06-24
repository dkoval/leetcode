package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConstructTargetArrayWithMultipleSumsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(9, 3, 5),
                // Explanation: Start with [1, 1, 1]
                // [1, 1, 1], sum = 3 choose index 1
                // [1, 3, 1], sum = 5 choose index 2
                // [1, 3, 5], sum = 9 choose index 0
                // [9, 3, 5] Done
                true
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 2),
                false
            ),
            Arguments.of(
                intArrayOf(8, 5),
                true
            ),
            Arguments.of(
                // tests TLE
                intArrayOf(1, 1000000000),
                true,
            ),
            Arguments.of(
                intArrayOf(2, 900000002),
                false
            ),
            Arguments.of(
                intArrayOf(1, 1, 10),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return True if it is possible to construct the target array from A otherwise return False`(
        target: IntArray,
        expected: Boolean
    ) {
        val actual = ConstructTargetArrayWithMultipleSums().isPossible(target)
        assertEquals(expected, actual)
    }
}