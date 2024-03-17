package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.InsertInterval.*
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class InsertIntervalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9)
                ),
                intArrayOf(2, 5),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(6, 9)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(4, 8),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(6, 7),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(1, 2),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(3, 5),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                )
            ),
            Arguments.of(
                arrayOf<IntArray>(),
                intArrayOf(5, 7),
                arrayOf(
                    intArrayOf(5, 7)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5)
                ),
                intArrayOf(6, 8),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(6, 8)
                )
            )
        )
    }

    @Nested
    inner class InsertIntervalRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should insert a new interval into into a set of non-overlapping intervals`(
            intervals: Array<IntArray>,
            newInterval: IntArray,
            expected: Array<IntArray>
        ) {
            InsertIntervalRev1().test(intervals, newInterval, expected)
        }
    }

    @Nested
    inner class InsertIntervalRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should insert a new interval into into a set of non-overlapping intervals`(
            intervals: Array<IntArray>,
            newInterval: IntArray,
            expected: Array<IntArray>
        ) {
            InsertIntervalRev2.test(intervals, newInterval, expected)
        }
    }

    @Nested
    inner class InsertIntervalRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should insert a new interval into into a set of non-overlapping intervals`(
            intervals: Array<IntArray>,
            newInterval: IntArray,
            expected: Array<IntArray>
        ) {
            InsertIntervalRev3().test(intervals, newInterval, expected)
        }
    }

    @Nested
    inner class InsertIntervalRev4Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should insert a new interval into into a set of non-overlapping intervals`(
            intervals: Array<IntArray>,
            newInterval: IntArray,
            expected: Array<IntArray>
        ) {
            InsertIntervalRev4().test(intervals, newInterval, expected)
        }
    }
}

private fun InsertInterval.test(intervals: Array<IntArray>, newInterval: IntArray, expected: Array<IntArray>) {
    val actual = insert(intervals, newInterval)
    assertArrayEquals(expected, actual)
}
