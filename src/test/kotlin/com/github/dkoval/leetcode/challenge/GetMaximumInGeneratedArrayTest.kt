package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GetMaximumInGeneratedArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(0, 0),
            Arguments.of(7, 3),
            Arguments.of(2, 1),
            Arguments.of(3, 2)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum integer in the array nums`(n: Int, expected: Int) {
        val actual = GetMaximumInGeneratedArray().getMaximumGenerated(n)
        assertEquals(expected, actual)
    }
}