package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddBinaryTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("11", "1", "100"),
            Arguments.of("1010", "1011", "10101")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return sum of two binary strings`(a: String, b: String, expected: String) {
        val actual = AddBinary.addBinary(a, b)
        assertEquals(expected, actual)
    }
}