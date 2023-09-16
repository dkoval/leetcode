package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PathWithMinimumEffort.PathWithMinimumEffortRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PathWithMinimumEffortTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 2),
                    intArrayOf(3, 8, 2),
                    intArrayOf(5, 3, 5)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(3, 8, 4),
                    intArrayOf(5, 3, 5)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 1, 1, 1),
                    intArrayOf(1, 2, 1, 2, 1),
                    intArrayOf(1, 2, 1, 2, 1),
                    intArrayOf(1, 2, 1, 2, 1),
                    intArrayOf(1, 1, 1, 2, 1)
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3)
                ),
                0
            )
        )
    }

    @Nested
    inner class PathWithMinimumEffortRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum effort required to travel from the top-left cell to the bottom-right cell`(
            heights: Array<IntArray>,
            expected: Int
        ) {
            PathWithMinimumEffort.PathWithMinimumEffortRev1().test(heights, expected)
        }
    }

    @Nested
    inner class PathWithMinimumEffortRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum effort required to travel from the top-left cell to the bottom-right cell`(
            heights: Array<IntArray>,
            expected: Int
        ) {
            PathWithMinimumEffortRev2().test(heights, expected)
        }
    }
}

private fun PathWithMinimumEffort.test(heights: Array<IntArray>, expected: Int) {
    val actual = minimumEffortPath(heights)
    assertEquals(expected, actual)
}
