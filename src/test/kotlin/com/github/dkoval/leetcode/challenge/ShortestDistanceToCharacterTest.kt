package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestDistanceToCharacter.ShortestDistanceToCharacterUsingLoHiRanges
import com.github.dkoval.leetcode.challenge.ShortestDistanceToCharacter.ShortestDistanceToCharacterUsingTreeSet
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestDistanceToCharacterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "loveleetcode",
                "e",
                intArrayOf(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0)
            ),
            Arguments.of(
                "aaab",
                "b",
                intArrayOf(3, 2, 1, 0)
            )
        )
    }

    @Nested
    inner class ShortestDistanceToCharacterUsingTreeSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return shortest distance to character`(s: String, c: Char, expected: IntArray) {
            ShortestDistanceToCharacterUsingTreeSet().test(s, c, expected)
        }
    }

    @Nested
    inner class ShortestDistanceToCharacterUsingLoHiRangesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return shortest distance to character`(s: String, c: Char, expected: IntArray) {
            ShortestDistanceToCharacterUsingLoHiRanges().test(s, c, expected)
        }
    }

    private fun ShortestDistanceToCharacter.test(s: String, c: Char, expected: IntArray) {
        val actual = shortestToChar(s, c)
        assertArrayEquals(expected, actual)
    }
}