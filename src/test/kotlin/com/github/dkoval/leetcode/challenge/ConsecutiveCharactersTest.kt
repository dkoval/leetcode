package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConsecutiveCharactersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("leetcode", 2),
            Arguments.of("abbcccddddeeeeedcba", 5),
            Arguments.of("triplepillooooow", 5),
            Arguments.of("hooraaaaaaaaaaay", 11),
            Arguments.of("tourist", 1)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the power of s`(s: String, expected: Int) {
        val actual = ConsecutiveCharacters().maxPower(s)
        assertEquals(expected, actual)
    }
}