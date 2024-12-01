package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidArrangementOfPairs.ValidArrangementOfPairsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidArrangementOfPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 1),
                    intArrayOf(4, 5),
                    intArrayOf(11, 9),
                    intArrayOf(9, 4)
                ),
                arrayOf(
                    intArrayOf(11, 9),
                    intArrayOf(9, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(3, 2),
                    intArrayOf(2, 1)
                ),
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(2, 1),
                    intArrayOf(1, 3)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 1)
                ),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(1, 3)
                )
            )
        )
    }

    @Nested
    inner class ValidArrangementOfPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any valid arrangement of pairs`(pairs: Array<IntArray>, expected: Array<IntArray>) {
            ValidArrangementOfPairsRev1().test(pairs, expected)
        }
    }
}

private fun ValidArrangementOfPairs.test(pairs: Array<IntArray>, expected: Array<IntArray>) {
    val actual = validArrangement(pairs)
    assertArrayEquals(expected, actual)
}
