package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestDistanceAfterRoadAdditionQueries1.ShortestDistanceAfterRoadAdditionQueries1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestDistanceAfterRoadAdditionQueries1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(2, 4),
                    intArrayOf(0, 2),
                    intArrayOf(0, 4)
                ),
                intArrayOf(3, 2, 1)
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(0, 2)
                ),
                intArrayOf(1, 1)
            )
        )
    }

    @Nested
    inner class ShortestDistanceAfterRoadAdditionQueries1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return an array answer where answer(i) is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries`(
            n: Int,
            queries: Array<IntArray>,
            expected: IntArray
        ) {
            ShortestDistanceAfterRoadAdditionQueries1Rev1().test(n, queries, expected)
        }
    }
}

private fun ShortestDistanceAfterRoadAdditionQueries1.test(n: Int, queries: Array<IntArray>, expected: IntArray) {
    val actual = shortestDistanceAfterQueries(n, queries)
    assertArrayEquals(expected, actual)
}
