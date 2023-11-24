package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfCoinsYouCanGet.MaximumNumberOfCoinsYouCanGetRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfCoinsYouCanGetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 4, 1, 2, 7, 8),
                9
            ),
            Arguments.of(
                intArrayOf(2, 4, 5),
                4
            ),
            Arguments.of(
                intArrayOf(9, 8, 7, 6, 5, 1, 2, 3, 4),
                18
            )
        )
    }

    @Nested
    inner class MaximumNumberOfCoinsYouCanGetRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of coins that you can have`(piles: IntArray, expected: Int) {
            MaximumNumberOfCoinsYouCanGetRev1().test(piles, expected)
        }
    }
}

private fun MaximumNumberOfCoinsYouCanGet.test(piles: IntArray, expected: Int) {
    val actual = maxCoins(piles)
    assertEquals(expected, actual)
}
