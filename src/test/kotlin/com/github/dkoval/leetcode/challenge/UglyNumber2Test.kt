package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UglyNumber2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 4),
            Arguments.of(5, 5),
            Arguments.of(10, 12)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find nth ugly number`(n: Int, expected: Int) {
        val actual = UglyNumber2.nthUglyNumber(n)
        assertEquals(expected, actual)
    }
}