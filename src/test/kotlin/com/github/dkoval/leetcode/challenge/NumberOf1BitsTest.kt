package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOf1BitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(0b00000000000000000000000000001011, 3),
            Arguments.of(0b00000000000000000000000010000000, 1),
            Arguments.of(-3, 31)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of 1 bits in an unsigned integer`(n: Int, expected: Int) {
        val actual = NumberOf1Bits().hammingWeight(n)
        assertEquals(expected, actual)
    }
}