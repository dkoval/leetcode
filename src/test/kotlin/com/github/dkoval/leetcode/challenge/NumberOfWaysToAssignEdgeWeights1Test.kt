package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToAssignEdgeWeights1.NumberOfWaysToAssignEdgeWeights1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class NumberOfWaysToAssignEdgeWeights1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(3, 4),
                    intArrayOf(3, 5)
                ),
                2
            )
        )
    }

    @Nested
    inner class NumberOfWaysToAssignEdgeWeights1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun ` Return the number of ways to assign edge weights in the path from node 1 to x such that its total cost is odd`(
            edges: Array<IntArray>,
            expected: Int
        ) {
            NumberOfWaysToAssignEdgeWeights1Rev1().test(edges, expected)
        }
    }
}

private fun NumberOfWaysToAssignEdgeWeights1.test(edges: Array<IntArray>, expected: Int) {
    val actual = assignEdgeWeights(edges)
    assertEquals(expected, actual)
}
