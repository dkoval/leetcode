package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.XOfAKindInADeckOfCards.XOfAKindInADeckOfCardsBruteForce
import com.github.dkoval.leetcode.mock.XOfAKindInADeckOfCards.XOfAKindInADeckOfCardsGCD
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class XOfAKindInADeckOfCardsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 4, 3, 2, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 2, 2, 2, 3, 3),
                false
            ),
            Arguments.of(
                intArrayOf(1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 2, 2),
                true
            )
        )
    }

    @Nested
    inner class XOfAKindInADeckOfCardsBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun hasGroupsSizeX(deck: IntArray, expected: Boolean) {
            XOfAKindInADeckOfCardsBruteForce().test(deck, expected)
        }
    }

    @Nested
    inner class XOfAKindInADeckOfCardsGCDTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun hasGroupsSizeX(deck: IntArray, expected: Boolean) {
            XOfAKindInADeckOfCardsGCD().test(deck, expected)
        }
    }

    private fun XOfAKindInADeckOfCards.test(deck: IntArray, expected: Boolean) {
        val actual = hasGroupsSizeX(deck)
        assertEquals(expected, actual)
    }
}