package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PathWithMaximumProbability.PathWithMaximumProbabilityRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PathWithMaximumProbabilityTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(0, 2)
                ),
                doubleArrayOf(0.5, 0.5, 0.2),
                0,
                2,
                0.25000
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(0, 2)
                ),
                doubleArrayOf(0.5, 0.5, 0.3),
                0,
                2,
                0.30000
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1)
                ),
                doubleArrayOf(0.5),
                0,
                2,
                0.00000
            )
        )
    }

    @Nested
    inner class PathWithMaximumProbabilityRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the path with the maximum probability of success to go from start to end`(
            n: Int,
            edges: Array<IntArray>,
            succProb: DoubleArray,
            start: Int,
            end: Int,
            expected: Double
        ) {
            PathWithMaximumProbabilityRev1().test(n, edges, succProb, start, end, expected)
        }
    }
}

private fun PathWithMaximumProbability.test(
    n: Int,
    edges: Array<IntArray>,
    succProb: DoubleArray,
    start: Int,
    end: Int,
    expected: Double
) {
    val actual = maxProbability(n, edges, succProb, start, end)
    assertEquals(expected, actual, 1e-5)
}
