package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfTwoIntegersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 2, 3),
            Arguments.of(2, 3, 5),
            Arguments.of(-42, 84, 42),
            Arguments.of(84, -42, 42)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the sum of the two integers without using the operators + and -`(a: Int, b: Int, expected: Int) {
        val actual = SumOfTwoIntegers().getSum(a, b)
        assertEquals(expected, actual)
    }
}