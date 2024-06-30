package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AllAncestorsOfNodeInDirectedAcyclicGraph.AllAncestorsOfNodeInDirectedAcyclicGraphRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AllAncestorsOfNodeInDirectedAcyclicGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                8,
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(0, 4),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 7),
                    intArrayOf(3, 5),
                    intArrayOf(3, 6),
                    intArrayOf(3, 7),
                    intArrayOf(4, 6)
                ),
                listOf(
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    listOf(0, 1),
                    listOf(0, 2),
                    listOf(0, 1, 3),
                    listOf(0, 1, 2, 3, 4),
                    listOf(0, 1, 2, 3)
                )
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(0, 4),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(3, 4)
                ),
                listOf(
                    emptyList(),
                    listOf(0),
                    listOf(0, 1),
                    listOf(0, 1, 2),
                    listOf(0, 1, 2, 3)
                )
            )
        )
    }

    @Nested
    inner class AllAncestorsOfNodeInDirectedAcyclicGraphRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list answer, where answer(i) is the list of ancestors of the ith node, sorted in ascending order`(
            n: Int,
            edges: Array<IntArray>,
            expected: List<List<Int>>
        ) {
            AllAncestorsOfNodeInDirectedAcyclicGraphRev1().test(n, edges, expected)
        }
    }
}

private fun AllAncestorsOfNodeInDirectedAcyclicGraph.test(n: Int, edges: Array<IntArray>, expected: List<List<Int>>) {
    val actual = getAncestors(n, edges)
    assertEquals(expected, actual)
}
