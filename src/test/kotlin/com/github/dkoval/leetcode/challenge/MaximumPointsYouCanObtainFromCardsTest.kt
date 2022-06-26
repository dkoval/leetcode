package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumPointsYouCanObtainFromCards.MaximumPointsYouCanObtainFromCardsRev1
import com.github.dkoval.leetcode.challenge.MaximumPointsYouCanObtainFromCards.MaximumPointsYouCanObtainFromCardsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumPointsYouCanObtainFromCardsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 1),
                3,
                12
            ),
            Arguments.of(
                intArrayOf(2, 2, 2),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(9, 7, 7, 9, 7, 7, 9),
                7,
                55
            ),
            Arguments.of(
                intArrayOf(1, 1000, 1),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(1, 79, 80, 1, 1, 1, 200, 1),
                3,
                202
            ),
            Arguments.of(
                intArrayOf(11, 49, 100, 20, 86, 29, 72),
                4,
                232
            )
        )
    }

    @Nested
    inner class MaximumPointsYouCanObtainFromCardsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score you can obtain`(cardPoints: IntArray, k: Int, expected: Int) {
            MaximumPointsYouCanObtainFromCardsRev1().test(cardPoints, k, expected)
        }
    }

    @Nested
    inner class MaximumPointsYouCanObtainFromCardsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score you can obtain`(cardPoints: IntArray, k: Int, expected: Int) {
            MaximumPointsYouCanObtainFromCardsRev2().test(cardPoints, k, expected)
        }
    }

    private fun MaximumPointsYouCanObtainFromCards.test(cardPoints: IntArray, k: Int, expected: Int) {
        val actual = maxScore(cardPoints, k)
        assertEquals(expected, actual)
    }
}