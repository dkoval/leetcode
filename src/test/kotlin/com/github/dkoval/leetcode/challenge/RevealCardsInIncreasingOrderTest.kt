package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RevealCardsInIncreasingOrder.RevealCardsInIncreasingOrderRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RevealCardsInIncreasingOrderTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(17, 13, 11, 2, 3, 5, 7),
                intArrayOf(2, 13, 3, 11, 5, 17, 7)
            ),
            Arguments.of(
                intArrayOf(1, 1000),
                intArrayOf(1, 1000)
            )
        )
    }

    @Nested
    inner class RevealCardsInIncreasingOrderRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an ordering of the deck that would reveal the cards in increasing order`(
            deck: IntArray,
            expected: IntArray
        ) {
            RevealCardsInIncreasingOrderRev1().test(deck, expected)
        }
    }
}

private fun RevealCardsInIncreasingOrder.test(deck: IntArray, expected: IntArray) {
    val actual = deckRevealedIncreasing(deck)
    assertArrayEquals(expected, actual)
}
