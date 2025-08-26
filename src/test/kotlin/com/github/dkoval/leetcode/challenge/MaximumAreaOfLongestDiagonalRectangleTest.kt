package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumAreaOfLongestDiagonalRectangle.MaximumAreaOfLongestDiagonalRectangleRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumAreaOfLongestDiagonalRectangleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 3),
                    intArrayOf(8, 6)
                ),
                48
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 4),
                    intArrayOf(4, 3)
                ),
                12
            )
        )
    }

    @Nested
    inner class MaximumAreaOfLongestDiagonalRectangleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the area of the rectangle having the longest diagonal`(
            points: Array<IntArray>,
            expected: Int
        ) {
            MaximumAreaOfLongestDiagonalRectangleRev1().test(points, expected)
        }
    }
}

private fun MaximumAreaOfLongestDiagonalRectangle.test(dimensions: Array<IntArray>, expected: Int) {
    val actual = areaOfMaxDiagonal(dimensions)
    assertEquals(expected, actual)
}
