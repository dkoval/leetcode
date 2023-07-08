package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PutMarblesInBags.PutMarblesInBagsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PutMarblesInBagsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 5, 1),
                2,
                4L
            ),
            Arguments.of(
                intArrayOf(1, 3),
                2,
                0L
            ),
            Arguments.of(
                intArrayOf(1, 4, 2, 5, 2),
                3,
                3L
            )
        )
    }

    @Nested
    inner class PutMarblesInBagsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the difference between the maximum and minimum scores among marble distributions`(
            weights: IntArray,
            k: Int,
            expected: Long
        ) {
            PutMarblesInBagsRev1().test(weights, k, expected)
        }
    }
}

private fun PutMarblesInBags.test(weights: IntArray, k: Int, expected: Long) {
    val actual = putMarbles(weights, k)
    assertEquals(expected, actual)
}
