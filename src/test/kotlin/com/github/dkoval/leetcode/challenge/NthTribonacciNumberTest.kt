package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NthTribonacciNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(4, 4),
            Arguments.of(25, 1389537)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return n-th Tribonacci number`(n: Int, expected: Int) {
        val actual = NthTribonacciNumber().tribonacci(n)
        assertEquals(expected, actual)
    }
}