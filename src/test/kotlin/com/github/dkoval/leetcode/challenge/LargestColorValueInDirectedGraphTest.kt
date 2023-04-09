package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestColorValueInDirectedGraph.LargestColorValueInDirectedGraphDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestColorValueInDirectedGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abaca",
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                ),
                3
            ),
            Arguments.of(
                "a",
                arrayOf(
                    intArrayOf(0, 0)
                ),
                -1
            ),
            Arguments.of(
                "nnllnzznn",
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(3, 5),
                    intArrayOf(4, 6),
                    intArrayOf(3, 6),
                    intArrayOf(5, 6),
                    intArrayOf(6, 7),
                    intArrayOf(7, 8)
                ),
                5
            )
        )
    }

    @Nested
    inner class LargestColorValueInDirectedGraphDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle`(
            colors: String,
            edges: Array<IntArray>,
            expected: Int
        ) {
            LargestColorValueInDirectedGraphDFS().test(colors, edges, expected)
        }
    }
}

private fun LargestColorValueInDirectedGraph.test(colors: String, edges: Array<IntArray>, expected: Int) {
    val actual = largestPathValue(colors, edges)
    assertEquals(expected, actual)
}
