package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PowerOfThreeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(27, true),
            Arguments.of(0, false),
            Arguments.of(9, true),
            Arguments.of(45, false),
            Arguments.of(17, false),
            Arguments.of(1, true),
            Arguments.of(3, true),
            Arguments.of(-3, false),
            Arguments.of(216, false),
            Arguments.of(12, false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if there exists an integer x such that n == 3x`(n: Int, expected: Boolean) {
        val actual = PowerOfThree().isPowerOfThree(n)
        assertEquals(expected, actual)
    }
}