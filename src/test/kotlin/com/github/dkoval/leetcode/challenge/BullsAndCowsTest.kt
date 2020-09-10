package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BullsAndCowsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class BullsAndCowsUsingTwoMapsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a hint according to the secret number and friend's guess`(
            secret: String,
            guess: String,
            expected: String
        ) {
            BullsAndCowsUsingTwoMaps.test(secret, guess, expected)
        }
    }

    @Nested
    inner class BullsAndCowsUsingTwoArraysTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a hint according to the secret number and friend's guess`(
            secret: String,
            guess: String,
            expected: String
        ) {
            BullsAndCowsUsingTwoArrays.test(secret, guess, expected)
        }
    }

    private fun BullsAndCows.test(secret: String, guess: String, expected: String) {
        val actual = getHint(secret, guess)
        assertEquals(expected, actual)
    }
}