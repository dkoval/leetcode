package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BaseballGameTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("5", "2", "C", "D", "+"),
                30
            ),
            Arguments.of(
                arrayOf("5", "-2", "4", "C", "D", "9", "+", "+"),
                27
            ),
            Arguments.of(
                arrayOf("1"),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of all the scores on the record`(ops: Array<String>, expected: Int) {
        val actual = BaseballGame().calPoints(ops)
        assertEquals(expected, actual)
    }
}