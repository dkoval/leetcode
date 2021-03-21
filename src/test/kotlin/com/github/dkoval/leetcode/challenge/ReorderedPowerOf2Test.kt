package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReorderedPowerOf2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, true),
            Arguments.of(10, false),
            Arguments.of(16, true),
            Arguments.of(24, false),
            Arguments.of(46, true)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if N is reordered power of 2`(N: Int, expected: Boolean) {
        val actual = ReorderedPowerOf2().reorderedPowerOf2(N)
        assertEquals(expected, actual)
    }
}