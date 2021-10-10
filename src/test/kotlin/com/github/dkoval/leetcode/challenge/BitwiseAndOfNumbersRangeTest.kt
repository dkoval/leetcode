package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BitwiseAndOfNumbersRangeTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(5, 7, 4),
            Arguments.of(0, 0, 0),
            Arguments.of(1, 2147483647, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the bitwise AND of all numbers in the given range, inclusive`(left: Int, right: Int, expected: Int) {
        val actual = BitwiseAndOfNumbersRange().rangeBitwiseAnd(left, right)
        assertEquals(expected, actual)
    }
}