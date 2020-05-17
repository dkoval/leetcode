package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidPerfectSquareTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(16, true),
            Arguments.of(14, false),
            Arguments.of(4539, false),
            Arguments.of(5776, true),
            Arguments.of(808201, true),
            Arguments.of(2147483647, false),
            Arguments.of(2147395600, true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if a number is a perfect square`(num: Int, expected: Boolean) {
        val actual = ValidPerfectSquare.isPerfectSquare(num)
        assertEquals(expected, actual)
    }
}