package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindClosestNodeToGivenTwoNodes.FindClosestNodeToGivenTwoNodesRev1
import com.github.dkoval.leetcode.challenge.FindClosestNodeToGivenTwoNodes.FindClosestNodeToGivenTwoNodesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindClosestNodeToGivenTwoNodesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 3, -1),
                0,
                1,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, -1),
                0,
                2,
                2
            ),
        )
    }

    @Nested
    inner class FindClosestNodeToGivenTwoNodesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of the node that can be reached from both node1 and node2`(
            edges: IntArray,
            node1: Int,
            node2: Int,
            expected: Int
        ) {
            FindClosestNodeToGivenTwoNodesRev1().test(edges, node1, node2, expected)
        }
    }

    @Nested
    inner class FindClosestNodeToGivenTwoNodesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the index of the node that can be reached from both node1 and node2`(
            edges: IntArray,
            node1: Int,
            node2: Int,
            expected: Int
        ) {
            FindClosestNodeToGivenTwoNodesRev2().test(edges, node1, node2, expected)
        }
    }
}

private fun FindClosestNodeToGivenTwoNodes.test(edges: IntArray, node1: Int, node2: Int, expected: Int) {
    val actual = closestMeetingNode(edges, node1, node2)
    assertEquals(expected, actual)
}
