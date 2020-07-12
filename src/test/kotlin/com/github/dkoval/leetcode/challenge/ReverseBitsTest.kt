package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseBitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                0b00000010100101000001111010011100,
                0b00111001011110000010100101000000
            ),
            Arguments.of(
                -3,
                -1073741825
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse bits`(n: Int, expected: Int) {
        val actual = ReverseBits.reverseBits(n)
        assertEquals(expected, actual)
    }
}