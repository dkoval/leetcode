package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RottingOranges.RottingOrangesUsingBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RottingOrangesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 1),
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 0, 1)
                ),
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                0
            )
        )
    }

    @Nested
    inner class RottingOrangesUsingBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of minutes that must elapse until no cell has a fresh orange`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            RottingOrangesUsingBFS().test(grid, expected)
        }
    }

    @Nested
    inner class RottingOrangesUsingTwoSetsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of minutes that must elapse until no cell has a fresh orange`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            RottingOrangesUsingTwoSets.test(grid, expected)
        }
    }

    private fun RottingOranges.test(grid: Array<IntArray>, expected: Int) {
        val actual = orangesRotting(grid)
        assertEquals(expected, actual)
    }
}