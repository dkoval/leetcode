package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ShortestPathVisitingAllNodes.ShortestPathVisitingAllNodesUsingBFSAndBitmask
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestPathVisitingAllNodesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(0),
                    intArrayOf(0),
                    intArrayOf(0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1),
                    intArrayOf(0, 2, 4),
                    intArrayOf(1, 3, 4),
                    intArrayOf(2),
                    intArrayOf(1, 2)
                ),
                4
            )
        )
    }

    @Nested
    inner class ShortestPathVisitingAllNodesUsingBFSAndBitmaskTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest path that visits every node`(
            graph: Array<IntArray>,
            expected: Int
        ) {
            ShortestPathVisitingAllNodesUsingBFSAndBitmask().test(graph, expected)
        }
    }

    private fun ShortestPathVisitingAllNodes.test(graph: Array<IntArray>, expected: Int) {
        val actual = shortestPathLength(graph)
        assertEquals(expected, actual)
    }
}