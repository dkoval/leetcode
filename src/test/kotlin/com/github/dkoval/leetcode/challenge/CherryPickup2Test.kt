package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CherryPickup2.CherryPickup2DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CherryPickup2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 1, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(1, 5, 5),
                    intArrayOf(2, 1, 1)
                ),
                24
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0, 0, 0, 0, 1),
                    intArrayOf(2, 0, 0, 0, 0, 3, 0),
                    intArrayOf(2, 0, 9, 0, 0, 0, 0),
                    intArrayOf(0, 3, 0, 5, 4, 0, 0),
                    intArrayOf(1, 0, 2, 3, 0, 0, 6)
                ),
                28
            )
        )
    }

    @Nested
    inner class CherryPickup2DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of cherries collection using both robots`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            CherryPickup2DPTopDown().test(grid, expected)
        }
    }
}

private fun CherryPickup2.test(grid: Array<IntArray>, expected: Int) {
    val actual = cherryPickup(grid)
    assertEquals(expected, actual)
}
