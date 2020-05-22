package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberComplementTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(5, 2),
            Arguments.of(1, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a positive integer compliment`(num: Int, expected: Int) {
        val actual = NumberComplement.findComplement(num)
        assertEquals(expected, actual)
    }
}