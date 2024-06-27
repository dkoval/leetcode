package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindCenterOfStarGraph.FindCenterOfStarGraphRev1
import com.github.dkoval.leetcode.challenge.FindCenterOfStarGraph.FindCenterOfStarGraphRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindCenterOfStarGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(4, 2)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(5, 1),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4)
                ),
                1
            )
        )
    }

    @Nested
    inner class FindCenterOfStarGraphRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the center of the given star graph`(edges: Array<IntArray>, expected: Int) {
            FindCenterOfStarGraphRev1().test(edges, expected)
        }
    }

    @Nested
    inner class FindCenterOfStarGraphRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the center of the given star graph`(edges: Array<IntArray>, expected: Int) {
            FindCenterOfStarGraphRev2().test(edges, expected)
        }
    }
}

private fun FindCenterOfStarGraph.test(edges: Array<IntArray>, expected: Int) {
    val actual = findCenter(edges)
    assertEquals(expected, actual)
}
