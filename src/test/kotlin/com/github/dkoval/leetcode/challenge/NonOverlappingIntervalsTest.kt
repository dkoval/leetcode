package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NonOverlappingIntervals.NonOverlappingIntervalsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NonOverlappingIntervalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 3)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 2)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(-100, -2),
                    intArrayOf(5, 7)
                ),
                0
            )
        )
    }

    @Nested
    inner class NonOverlappingIntervalsKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum number of intervals to remove to make the rest of the intervals non-overlapping`(
            intervals: Array<IntArray>,
            expected: Int
        ) {
            NonOverlappingIntervalsKt.test(intervals, expected)
        }
    }

    @Nested
    inner class NonOverlappingIntervalsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum number of intervals to remove to make the rest of the intervals non-overlapping`(
            intervals: Array<IntArray>,
            expected: Int
        ) {
            NonOverlappingIntervalsRev1().test(intervals, expected)
        }
    }
}

private fun NonOverlappingIntervals.test(intervals: Array<IntArray>, expected: Int) {
    val actual = eraseOverlapIntervals(intervals)
    assertEquals(expected, actual)
}
