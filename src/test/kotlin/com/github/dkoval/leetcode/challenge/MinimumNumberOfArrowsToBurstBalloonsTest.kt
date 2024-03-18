package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfArrowsToBurstBalloons.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfArrowsToBurstBalloonsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 16),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 12)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(5, 6),
                    intArrayOf(7, 8)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(2,3),
                    intArrayOf(3,4),
                    intArrayOf(4,5)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(2, 3)
                ),
                1
            )
        )
    }

    @Nested
    inner class MinimumNumberOfArrowsToBurstBalloonsSortByEndPointTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of arrows that must be shot to burst all balloons`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfArrowsToBurstBalloonsSortByEndPoint().test(points, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfArrowsToBurstBalloonsSortByStartPointRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of arrows that must be shot to burst all balloons`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfArrowsToBurstBalloonsSortByStartPointRev1().test(points, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfArrowsToBurstBalloonsSortByStartPointRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of arrows that must be shot to burst all balloons`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfArrowsToBurstBalloonsSortByStartPointRev2().test(points, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfArrowsToBurstSweepLineTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of arrows that must be shot to burst all balloons`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfArrowsToBurstSweepLine().test(points, expected)
        }
    }

    private fun MinimumNumberOfArrowsToBurstBalloons.test(points: Array<IntArray>, expected: Int) {
        val actual = findMinArrowShots(points)
        assertEquals(expected, actual)
    }
}