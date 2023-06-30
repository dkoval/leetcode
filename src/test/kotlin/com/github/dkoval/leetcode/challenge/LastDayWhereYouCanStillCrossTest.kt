package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LastDayWhereYouCanStillCross.LastDayWhereYouCanStillCrossRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LastDayWhereYouCanStillCrossTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                2,
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 2)
                ),
                2
            ),
            Arguments.of(
                2,
                2,
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2)
                ),
                1
            ),
            Arguments.of(
                3,
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(3, 3),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 2),
                    intArrayOf(3, 1)
                ),
                3
            )
        )
    }

    @Nested
    inner class LastDayWhereYouCanStillCrossRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the last day where it is possible to walk from the top to the bottom by only walking on land cells`(
            row: Int,
            col: Int,
            cells: Array<IntArray>,
            expected: Int
        ) {
            LastDayWhereYouCanStillCrossRev1().test(row, col, cells, expected)
        }
    }
}

private fun LastDayWhereYouCanStillCross.test(row: Int, col: Int, cells: Array<IntArray>, expected: Int) {
    val actual = latestDayToCross(row, col, cells)
    assertEquals(expected, actual)
}
