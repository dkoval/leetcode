package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumValueOfKCoinsFromPiles.MaximumValueOfKCoinsFromPilesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumValueOfKCoinsFromPilesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 100, 3),

                    ),
                2,
                101
            ),
            Arguments.of(
                listOf(
                    listOf(100),
                    listOf(100),
                    listOf(100),
                    listOf(100),
                    listOf(100),
                    listOf(100),
                    listOf(1, 1, 1, 1, 1, 1, 700)
                ),
                7,
                706
            )
        )
    }

    @Nested
    inner class MaximumValueOfKCoinsFromPilesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally`(
            piles: List<List<Int>>,
            k: Int,
            expected: Int
        ) {
            MaximumValueOfKCoinsFromPilesDPTopDown().test(piles, k, expected)
        }
    }
}

private fun MaximumValueOfKCoinsFromPiles.test(piles: List<List<Int>>, k: Int, expected: Int) {
    val actual = maxValueOfCoins(piles, k)
    assertEquals(expected, actual)
}
