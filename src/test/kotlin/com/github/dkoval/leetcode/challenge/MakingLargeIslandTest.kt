package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakingLargeIsland.MakingLargeIslandRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakingLargeIslandTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(1, 0, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 0, 0)
                ),
                18
            )
        )
    }

    @Nested
    inner class MakingLargeIslandRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest island in grid after changing ot most one 0 to 1`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MakingLargeIslandRev1().test(grid, expected)
        }
    }
}

private fun MakingLargeIsland.test(grid: Array<IntArray>, expected: Int) {
    val actual = largestIsland(grid)
    assertEquals(expected, actual)
}
