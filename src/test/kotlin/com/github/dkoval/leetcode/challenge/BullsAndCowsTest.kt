package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BullsAndCowsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "1807",
                "7810",
                "1A3B"
            ),
            Arguments.of(
                "1123",
                "0111",
                "1A1B"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a hint according to the secret number and friend's guess`(
        secret: String,
        guess: String,
        expected: String
    ) {
        val actual = BullsAndCows.getHint(secret, guess)
        assertEquals(expected, actual)
    }
}