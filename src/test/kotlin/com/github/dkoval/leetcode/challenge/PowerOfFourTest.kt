package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PowerOfFourTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(16, true),
            Arguments.of(32, false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check whether a number is a power of 4`(num: Int, expected: Boolean) {
        val actual = PowerOfFour.isPowerOfFour(num)
        assertEquals(expected, actual)
    }
}