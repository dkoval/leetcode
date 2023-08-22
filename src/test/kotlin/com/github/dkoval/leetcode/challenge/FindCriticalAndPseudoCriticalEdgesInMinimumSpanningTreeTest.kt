package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree.FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 2),
                    intArrayOf(0, 3, 2),
                    intArrayOf(0, 4, 3),
                    intArrayOf(3, 4, 3),
                    intArrayOf(1, 4, 6)
                ),
                listOf(
                    listOf(0, 1),
                    listOf(2, 3, 4, 5)
                )
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 1),
                    intArrayOf(0, 3, 1)
                ),
                listOf(
                    emptyList(),
                    listOf(0, 1, 2, 3)
                )
            ),
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 2, 1),
                    intArrayOf(2, 3, 4),
                    intArrayOf(3, 4, 2),
                    intArrayOf(3, 5, 2),
                    intArrayOf(4, 5, 2)
                ),
                listOf(
                    listOf(3),
                    listOf(0, 1, 2, 4, 5, 6)
                )
            )
        )
    }

    @Nested
    inner class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all the critical and pseudo-critical edges in the given graph's minimum spanning tree`(
            n: Int,
            edges: Array<IntArray>,
            expected: List<List<Int>>
        ) {
            FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTreeRev1().test(n, edges, expected)
        }
    }
}

private fun FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree.test(
    n: Int,
    edges: Array<IntArray>,
    expected: List<List<Int>>
) {
    val actual = findCriticalAndPseudoCriticalEdges(n, edges)
    assertEquals(2, actual.size)
    assertThat(actual[0]).containsExactlyInAnyOrderElementsOf(expected[0])
    assertThat(actual[1]).containsExactlyInAnyOrderElementsOf(expected[1])
}
