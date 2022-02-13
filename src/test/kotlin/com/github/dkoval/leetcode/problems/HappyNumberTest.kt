package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HappyNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(19, true),
            Arguments.of(2, false),
            Arguments.of(5, false),
            Arguments.of(6, false),
            Arguments.of(7, true),
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return true if n is a happy number`(n: Int, expected: Boolean) {
        val actual = HappyNumber().isHappy(n)
        assertEquals(expected, actual)
    }
}