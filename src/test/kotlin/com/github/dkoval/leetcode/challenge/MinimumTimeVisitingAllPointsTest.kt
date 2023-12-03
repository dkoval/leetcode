package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeVisitingAllPoints.MinimumTimeVisitingAllPointsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeVisitingAllPointsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 4),
                    intArrayOf(-1, 0)
                ),
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(-2, 2)
                ),
                5
            )
        )
    }

    @Nested
    inner class MinimumTimeVisitingAllPointsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time in seconds to visit all the points in the order given by points`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MinimumTimeVisitingAllPointsRev1().test(points, expected)
        }
    }
}

private fun MinimumTimeVisitingAllPoints.test(points: Array<IntArray>, expected: Int) {
    val actual = minTimeToVisitAllPoints(points)
    assertEquals(expected, actual)
}
