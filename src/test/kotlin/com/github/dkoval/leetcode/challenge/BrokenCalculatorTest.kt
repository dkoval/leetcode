package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class BrokenCalculatorTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // 2 -> 4 -> 3
            Arguments.of(2, 3, 2),
            // 5 -> 4 -> 8
            Arguments.of(5, 8, 2),
            // 3 -> 6 -> 5 -> 10
            Arguments.of(3, 10, 3),
            // use decrement operations 1023 times
            Arguments.of(1024, 1, 1023)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of operations needed to display the number Y`(
        X: Int,
        Y: Int,
        expected: Int
    ) {
        val actual = BrokenCalculator().brokenCalc(X, Y)
        assertEquals(expected, actual)
    }
}