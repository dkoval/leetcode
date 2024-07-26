package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindWithSmallestNumberOfNeighborsAtThresholdDistance.FindWithSmallestNumberOfNeighborsAtThresholdDistanceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindWithSmallestNumberOfNeighborsAtThresholdDistanceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 1, 3),
                    intArrayOf(1, 2, 1),
                    intArrayOf(1, 3, 4),
                    intArrayOf(2, 3, 1)
                ),
                4,
                3
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1, 2),
                    intArrayOf(0, 4, 8),
                    intArrayOf(1, 2, 3),
                    intArrayOf(1, 4, 2),
                    intArrayOf(2, 3, 1),
                    intArrayOf(3, 4, 1)
                ),
                2,
                0
            )
        )
    }

    @Nested
    inner class FindWithSmallestNumberOfNeighborsAtThresholdDistanceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold`(
            n: Int,
            edges: Array<IntArray>,
            distanceThreshold: Int,
            expected: Int
        ) {
            FindWithSmallestNumberOfNeighborsAtThresholdDistanceRev1().test(n, edges, distanceThreshold, expected)
        }
    }
}

private fun FindWithSmallestNumberOfNeighborsAtThresholdDistance.test(
    n: Int,
    edges: Array<IntArray>,
    distanceThreshold: Int,
    expected: Int
) {
    val actual = findTheCity(n, edges, distanceThreshold)
    assertEquals(expected, actual)
}
