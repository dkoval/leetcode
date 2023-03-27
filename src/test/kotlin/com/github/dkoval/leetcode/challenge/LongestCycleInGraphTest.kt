package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestCycleInGraph.LongestCycleInGraphRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestCycleInGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 3, 4, 2, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, -1, 3, 1),
                -1
            )
        )
    }

    @Nested
    inner class LongestCycleInGraphRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest cycle in the graph`(edges: IntArray, expected: Int) {
            LongestCycleInGraphRev1().test(edges, expected)
        }
    }
}

private fun LongestCycleInGraph.test(edges: IntArray, expected: Int) {
    val actual = longestCycle(edges)
    assertEquals(expected, actual)
}
