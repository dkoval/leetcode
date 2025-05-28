package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeNumberOfTargetNodesAfterConnectingTrees1.MaximizeNumberOfTargetNodesAfterConnectingTrees1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximizeNumberOfTargetNodesAfterConnectingTrees1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4)
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(2, 7),
                    intArrayOf(1, 4),
                    intArrayOf(4, 5),
                    intArrayOf(4, 6)
                ),
                2,
                intArrayOf(9, 7, 9, 8, 8)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(0, 4)
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3)
                ),
                1,
                intArrayOf(6, 3, 3, 3, 3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1)
                ),
                arrayOf(
                    intArrayOf(0, 1)
                ),
                0,
                intArrayOf(1, 1)
            )
        )
    }

    @Nested
    inner class MaximizeNumberOfTargetNodesAfterConnectingTrees1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return array answer where answer(i) is the max possible number of nodes target to node i of the 1st tree if you have to connect one node from the 1st tree to another node in the 2nd tree`(
            edges1: Array<IntArray>,
            edges2: Array<IntArray>,
            k: Int,
            expected: IntArray
        ) {
            MaximizeNumberOfTargetNodesAfterConnectingTrees1Rev1().test(edges1, edges2, k, expected)
        }
    }
}

private fun MaximizeNumberOfTargetNodesAfterConnectingTrees1.test(
    edges1: Array<IntArray>,
    edges2: Array<IntArray>,
    k: Int,
    expected: IntArray
) {
    val actual = maxTargetNodes(edges1, edges2, k)
    assertArrayEquals(expected, actual)
}
