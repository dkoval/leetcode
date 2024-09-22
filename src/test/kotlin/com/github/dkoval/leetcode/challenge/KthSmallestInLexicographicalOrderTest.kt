package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthSmallestInLexicographicalOrder.KthSmallestInLexicographicalOrderTLE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthSmallestInLexicographicalOrderTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(13, 2, 10),
            Arguments.of(1, 1, 1),
            Arguments.of(100, 10, 17),
            Arguments.of(681692778, 351251360, 416126219)
        )
    }

    @Nested
    inner class KthSmallestInLexicographicalOrderTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth lexicographically smallest integer in the range from 1 to n`(
            n: Int,
            k: Int,
            expected: Int
        ) {
            KthSmallestInLexicographicalOrderTLE().test(n, k, expected)
        }
    }
}

private fun KthSmallestInLexicographicalOrder.test(n: Int, k: Int, expected: Int) {
    val actual = findKthNumber(n, k)
    assertEquals(expected, actual)
}
