package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveCoveredIntervalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(3, 6),
                    intArrayOf(2, 8)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 10),
                    intArrayOf(5,12)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 10),
                    intArrayOf(4, 10),
                    intArrayOf(5, 11)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 4),
                    intArrayOf(3, 4)
                ),
                1
            )
        )
    }

    @Nested
    inner class RemoveCoveredIntervalsKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of remaining intervals after covered intervals were removed`(
            intervals: Array<IntArray>,
            expected: Int
        ) {
            RemoveCoveredIntervalsKt.test(intervals, expected)
        }
    }

    @Nested
    inner class RemoveCoveredIntervalsJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of remaining intervals after covered intervals were removed`(
            intervals: Array<IntArray>,
            expected: Int
        ) {
            RemoveCoveredIntervalsJava().test(intervals, expected)
        }
    }

    private fun RemoveCoveredIntervals.test(intervals: Array<IntArray>, expected: Int) {
        val actual = removeCoveredIntervals(intervals)
        assertEquals(expected, actual)
    }
}