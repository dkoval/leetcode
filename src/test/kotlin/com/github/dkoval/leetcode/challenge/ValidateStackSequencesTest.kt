package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidateStackSequencesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 5, 3, 2, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 3, 5, 1, 2),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate stack sequences`(pushed: IntArray, popped: IntArray, expected: Boolean) {
        val actual = ValidateStackSequences().validateStackSequences(pushed, popped)
        assertEquals(expected, actual)
    }
}