package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MaximalNetworkRank.MaximalNetworkRankRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximalNetworkRankTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 3),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                4
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 3),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                ),
                5
            ),
            Arguments.of(
                8,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(5, 6),
                    intArrayOf(5, 7),
                ),
                5
            )
        )
    }

    @Nested
    inner class MaximalNetworkRankRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximal network rank`(n: Int, roads: Array<IntArray>, expected: Int) {
            MaximalNetworkRankRev1().test(n, roads, expected)
        }
    }

    private fun MaximalNetworkRank.test(n: Int, roads: Array<IntArray>, expected: Int) {
        val actual = maximalNetworkRank(n, roads)
        assertEquals(expected, actual)
    }
}