package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountUnreachablePairsOfNodesInUndirectedGraph.CountUnreachablePairsOfNodesInUndirectedGraphUsingBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountUnreachablePairsOfNodesInUndirectedGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)
                ),
                0L
            ),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 2), intArrayOf(0, 5), intArrayOf(2, 4), intArrayOf(1, 6), intArrayOf(5, 4)
                ),
                14L
            ),
            Arguments.of(
                100000,
                emptyArray<IntArray>(),
                4999950000L
            )
        )
    }

    @Nested
    inner class CountUnreachablePairsOfNodesInUndirectedGraphUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs of different nodes that are unreachable from each other`(
            n: Int,
            edges: Array<IntArray>,
            expected: Long
        ) {
            CountUnreachablePairsOfNodesInUndirectedGraphUsingBFS().test(n, edges, expected)
        }
    }
}

private fun CountUnreachablePairsOfNodesInUndirectedGraph.test(n: Int, edges: Array<IntArray>, expected: Long) {
    val actual = countPairs(n, edges)
    assertEquals(expected, actual)
}
