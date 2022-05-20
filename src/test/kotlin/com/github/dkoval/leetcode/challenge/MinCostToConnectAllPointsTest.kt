package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinCostToConnectAllPoints.MinCostToConnectAllPointsUsingPrim
import com.github.dkoval.leetcode.challenge.MinCostToConnectAllPoints.MinCostToConnectAllPointsUsingUnionFind
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinCostToConnectAllPointsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 2),
                    intArrayOf(3, 10),
                    intArrayOf(5, 2),
                    intArrayOf(7, 0)
                ),
                20
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 12),
                    intArrayOf(-2, 5),
                    intArrayOf(-4, 1)
                ),
                18
            )
        )
    }

    @Nested
    inner class MinCostToConnectAllPointsUsingUnionFindTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to make all points connected`(points: Array<IntArray>, expected: Int) {
            MinCostToConnectAllPointsUsingUnionFind().test(points, expected)
        }
    }

    @Nested
    inner class MinCostToConnectAllPointsUsingPrimTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to make all points connected`(points: Array<IntArray>, expected: Int) {
            MinCostToConnectAllPointsUsingPrim().test(points, expected)
        }
    }

    private fun MinCostToConnectAllPoints.test(points: Array<IntArray>, expected: Int) {
        val actual = minCostConnectPoints(points)
        assertEquals(expected, actual)
    }
}