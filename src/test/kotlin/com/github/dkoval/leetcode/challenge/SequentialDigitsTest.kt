package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SequentialDigitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                100,
                300,
                listOf(123, 234)
            ),
            Arguments.of(
                1000,
                13000,
                listOf(1234, 2345, 3456, 4567, 5678, 6789, 12345)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a sorted list of all the integers in the low to high range  inclusive that have sequential digits`(
        low: Int,
        high: Int,
        expected: List<Int>
    ) {
        val actual = SequentialDigits.sequentialDigits(low, high)
        assertEquals(expected, actual)
    }
}