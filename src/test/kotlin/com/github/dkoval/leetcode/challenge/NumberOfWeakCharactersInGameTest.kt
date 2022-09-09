package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWeakCharactersInGame.NumberOfWeakCharactersInGameTLE
import com.github.dkoval.leetcode.challenge.NumberOfWeakCharactersInGame.NumberOfWeakCharactersInGameUsingSorting
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWeakCharactersInGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 5),
                    intArrayOf(6, 3),
                    intArrayOf(3, 6)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(10, 4),
                    intArrayOf(4, 3)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 7),
                    intArrayOf(1, 2),
                    intArrayOf(9, 7),
                    intArrayOf(7, 3),
                    intArrayOf(3, 10),
                    intArrayOf(9, 8),
                    intArrayOf(8, 10),
                    intArrayOf(4, 3),
                    intArrayOf(1, 5),
                    intArrayOf(1, 5)
                ),
                6
            )
        )
    }

    @Nested
    inner class NumberOfWeakCharactersInGameTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of weak characters`(properties: Array<IntArray>, expected: Int) {
            NumberOfWeakCharactersInGameTLE().test(properties, expected)
        }
    }

    @Nested
    inner class NumberOfWeakCharactersInGameUsingSortingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of weak characters`(properties: Array<IntArray>, expected: Int) {
            NumberOfWeakCharactersInGameUsingSorting().test(properties, expected)
        }
    }

    private fun NumberOfWeakCharactersInGame.test(properties: Array<IntArray>, expected: Int) {
        val actual = numberOfWeakCharacters(properties)
        assertEquals(expected, actual)
    }
}