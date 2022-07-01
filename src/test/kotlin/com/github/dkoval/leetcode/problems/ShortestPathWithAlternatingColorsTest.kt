package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ShortestPathWithAlternatingColors.ShortestPathWithAlternatingColorsBFS
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestPathWithAlternatingColorsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2)
                ),
                arrayOf<IntArray>(),
                intArrayOf(0, 1, -1)
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1)
                ),
                arrayOf(
                    intArrayOf(2, 1)
                ),
                intArrayOf(0, 1, -1)
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2)
                ),
                arrayOf(
                    intArrayOf(1, 0)
                ),
                intArrayOf(0, 1, 1)
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                ),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
                ),
                intArrayOf(0, 1, 2, 3, 7)
            )
        )
    }

    @Nested
    inner class ShortestPathWithAlternatingColorsBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the length of the shortest path from node 0 to node i such that the edge colors alternate`(
            n: Int,
            redEdges: Array<IntArray>,
            blueEdges: Array<IntArray>,
            expected: IntArray
        ) {
            ShortestPathWithAlternatingColorsBFS().test(n, redEdges, blueEdges, expected)
        }
    }

    private fun ShortestPathWithAlternatingColors.test(
        n: Int,
        redEdges: Array<IntArray>,
        blueEdges: Array<IntArray>,
        expected: IntArray
    ) {
        val actual = shortestAlternatingPaths(n, redEdges, blueEdges)
        assertArrayEquals(expected, actual)
    }
}