package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumNumberOfVerticesToReachAllNodesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                6,
                listOf(
                    listOf(0, 1),
                    listOf(0, 2),
                    listOf(2, 5),
                    listOf(3, 4),
                    listOf(4, 2)
                ),
                listOf(0, 3)
            ),
            Arguments.of(
                5,
                listOf(
                    listOf(0, 1),
                    listOf(2, 1),
                    listOf(3, 1),
                    listOf(1, 4),
                    listOf(2, 4)
                ),
                listOf(0, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find the smallest set of vertices from which all nodes in the graph are reachable`(
        n: Int,
        edges: List<List<Int>>,
        expected: List<Int>
    ) {
        val actual = MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(n, edges)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}