package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumScoreOfPathBetweenTwoCities.MinimumScoreOfPathBetweenTwoCitiesUsingBFS
import com.github.dkoval.leetcode.challenge.MinimumScoreOfPathBetweenTwoCities.MinimumScoreOfPathBetweenTwoCitiesUsingDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumScoreOfPathBetweenTwoCitiesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 2, 9),
                    intArrayOf(2, 3, 6),
                    intArrayOf(2, 4, 5),
                    intArrayOf(1, 4, 7)
                ),
                5
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 2, 2),
                    intArrayOf(1, 3, 4),
                    intArrayOf(3, 4, 7)
                ),
                2
            )
        )
    }

    @Nested
    inner class MinimumScoreOfPathBetweenTwoCitiesUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible score of a path between cities 1 and n`(
            n: Int,
            roads: Array<IntArray>,
            expected: Int
        ) {
            MinimumScoreOfPathBetweenTwoCitiesUsingBFS().test(n, roads, expected)
        }
    }

    @Nested
    inner class MinimumScoreOfPathBetweenTwoCitiesUsingDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible score of a path between cities 1 and n`(
            n: Int,
            roads: Array<IntArray>,
            expected: Int
        ) {
            MinimumScoreOfPathBetweenTwoCitiesUsingDFS().test(n, roads, expected)
        }
    }
}

private fun MinimumScoreOfPathBetweenTwoCities.test(n: Int, roads: Array<IntArray>, expected: Int) {
    val actual = minScore(n, roads)
    assertEquals(expected, actual)
}
