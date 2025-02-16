package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConstructLexicographicallyLargestValidSequence.ConstructLexicographicallyLargestValidSequenceRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstructLexicographicallyLargestValidSequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                intArrayOf(3, 1, 2, 3, 2)
            ),
            Arguments.of(
                5,
                intArrayOf(5, 3, 1, 4, 3, 5, 2, 4, 2)
            )
        )
    }

    @Nested
    inner class ConstructLexicographicallyLargestValidSequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should construct a lexicographically largest valid sequence`(n: Int, expected: IntArray) {
            ConstructLexicographicallyLargestValidSequenceRev1().test(n, expected)
        }
    }
}

private fun ConstructLexicographicallyLargestValidSequence.test(n: Int, expected: IntArray) {
    val actual = constructDistancedSequence(n)
    assertArrayEquals(expected, actual)
}
