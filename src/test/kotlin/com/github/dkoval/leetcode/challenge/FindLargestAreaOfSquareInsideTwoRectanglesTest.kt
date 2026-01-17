package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLargestAreaOfSquareInsideTwoRectangles.FindLargestAreaOfSquareInsideTwoRectanglesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLargestAreaOfSquareInsideTwoRectanglesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 1)
                ),
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(4, 4),
                    intArrayOf(6, 6)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 3),
                    intArrayOf(1, 5)
                ),
                arrayOf(
                    intArrayOf(5, 5),
                    intArrayOf(5, 7),
                    intArrayOf(5, 9)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(1, 2)
                ),
                arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(4, 4),
                    intArrayOf(3, 4)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 3),
                    intArrayOf(3, 1)
                ),
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(4, 4),
                    intArrayOf(4, 2)
                ),
                0
            )
        )
    }

    @Nested
    inner class FindLargestAreaOfSquareInsideTwoRectanglesTestRev1 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum area of a square that can fit inside the intersecting region of at least two rectangles`(
            bottomLeft: Array<IntArray>,
            topRight: Array<IntArray>,
            expected: Long
        ) {
            FindLargestAreaOfSquareInsideTwoRectanglesRev1().test(bottomLeft, topRight, expected)
        }
    }
}

private fun FindLargestAreaOfSquareInsideTwoRectangles.test(
    bottomLeft: Array<IntArray>,
    topRight: Array<IntArray>,
    expected: Long
) {
    val actual = largestSquareArea(bottomLeft, topRight)
    assertEquals(expected, actual)
}
