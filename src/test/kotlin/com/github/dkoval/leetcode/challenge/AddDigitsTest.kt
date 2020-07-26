package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddDigitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(38, 2), // 3 + 8 = 11, 1 + 1 = 2
            Arguments.of(283, 4) // 2 + 8 + 3 = 13, 1 + 3 = 4
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute digital root`(num: Int, expected: Int) {
        val actual = AddDigits.addDigits(num)
        assertEquals(expected, actual)
    }
}