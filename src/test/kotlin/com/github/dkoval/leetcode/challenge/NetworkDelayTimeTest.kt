package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NetworkDelayTime.NetworkDelayTimeUsingBFS
import com.github.dkoval.leetcode.challenge.NetworkDelayTime.NetworkDelayTimeUsingDijkstra
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NetworkDelayTimeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(2, 3, 1),
                    intArrayOf(3, 4, 1)
                ),
                4,
                2,
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 1)
                ),
                2,
                1,
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 1)
                ),
                2,
                2,
                -1
            )
        )
    }

    @Nested
    inner class NetworkDelayTimeUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the time it takes for all the n nodes to receive the signal`(
            times: Array<IntArray>,
            n: Int,
            k: Int,
            expected: Int
        ) {
            NetworkDelayTimeUsingBFS().test(times, n, k, expected)
        }
    }

    @Nested
    inner class NetworkDelayTimeUsingDijkstraTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the time it takes for all the n nodes to receive the signal`(
            times: Array<IntArray>,
            n: Int,
            k: Int,
            expected: Int
        ) {
            NetworkDelayTimeUsingDijkstra().test(times, n, k, expected)
        }
    }

    private fun NetworkDelayTime.test(times: Array<IntArray>, n: Int, k: Int, expected: Int) {
        val actual = networkDelayTime(times, n, k)
        assertEquals(expected, actual)
    }
}