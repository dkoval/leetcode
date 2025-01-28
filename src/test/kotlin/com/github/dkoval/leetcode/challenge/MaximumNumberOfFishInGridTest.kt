package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfFishInGrid.MaximumNumberOfFishInGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfFishInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2, 1, 0),
                    intArrayOf(4, 0, 0, 3),
                    intArrayOf(1, 0, 0, 4),
                    intArrayOf(0, 3, 2, 0)
                ),
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 1)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 5),
                    intArrayOf(8, 0)
                ),
                23
            )
        )
    }

    @Nested
    inner class MaximumNumberOfFishInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of fish the fisher can catch if he chooses his starting cell optimally`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MaximumNumberOfFishInGridRev1().test(grid, expected)
        }
    }
}

private fun MaximumNumberOfFishInGrid.test(grid: Array<IntArray>, expected: Int) {
    val actual = findMaxFish(grid)
    assertEquals(expected, actual)
}
