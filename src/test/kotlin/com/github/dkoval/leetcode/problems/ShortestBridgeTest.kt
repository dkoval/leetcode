package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ShortestBridge.ShortestBridgeUsingDFSAndBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestBridgeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 1)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0, 1),
                    intArrayOf(1, 0, 1, 0, 1),
                    intArrayOf(1, 0, 0, 0, 1),
                    intArrayOf(1, 1, 1, 1, 1)
                ),
                1
            )
        )
    }

    @Nested
    inner class ShortestBridgeUsingDFSAndBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest number of 0's you must flip to connect the two islands`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            ShortestBridgeUsingDFSAndBFS().test(grid, expected)
        }
    }

    private fun ShortestBridge.test(grid: Array<IntArray>, expected: Int) {
        val actual = shortestBridge(grid)
        assertEquals(expected, actual)
    }
}