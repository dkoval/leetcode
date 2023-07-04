package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SingleNumber2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 2, 3, 2),
                3
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 1, 0, 1, 99),
                99
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find an integer which appears exactly once`(nums: IntArray, expected: Int) {
        val actual = SingleNumber2.singleNumber(nums)
        assertEquals(expected, actual)
    }
}