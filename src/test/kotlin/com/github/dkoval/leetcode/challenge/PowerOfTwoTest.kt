package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PowerOfTwoTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, true),
            Arguments.of(16, true),
            Arguments.of(218, false),
            Arguments.of(0, false),
            Arguments.of(Int.MIN_VALUE, false),
            Arguments.of(Int.MAX_VALUE, false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if a given integer is a power of two`(n: Int, expected: Boolean) {
        val actual = PowerOfTwo.isPowerOfTwo(n)
        assertEquals(expected, actual)
    }
}