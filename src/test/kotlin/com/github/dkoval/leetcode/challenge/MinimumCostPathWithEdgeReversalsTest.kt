package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostPathWithEdgeReversals.MinimumCostPathWithEdgeReversalsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCostPathWithEdgeReversalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    4,
                    arrayOf(
                        intArrayOf(0, 1, 3),
                        intArrayOf(3, 1, 1),
                        intArrayOf(2, 3, 4),
                        intArrayOf(0, 2, 2)
                    ),
                    5
                ),
                Arguments.of(
                    4,
                    arrayOf(
                        intArrayOf(0, 2, 1),
                        intArrayOf(2, 1, 1),
                        intArrayOf(1, 3, 1),
                        intArrayOf(2, 3, 3)
                    ),
                    3
                ),
                Arguments.of(
                    5,
                    arrayOf(
                        intArrayOf(1, 2, 8),
                        intArrayOf(3, 1, 10),
                        intArrayOf(0, 3, 3)
                    ),
                    -1
                )
            )
        }
    }

    @Nested
    inner class MinimumCostPathWithEdgeReversalsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to reach from node 0 to node n - 1`(
            n: Int,
            edges: Array<IntArray>,
            expected: Int
        ) {
            MinimumCostPathWithEdgeReversalsRev1().test(n, edges, expected)
        }
    }
}

private fun MinimumCostPathWithEdgeReversals.test(n: Int, edges: Array<IntArray>, expected: Int) {
    val actual = minCost(n, edges)
    assertEquals(expected, actual)
}
