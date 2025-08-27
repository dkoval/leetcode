package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LengthOfLongestVShapedDiagonalSegment.LengthOfLongestVShapedDiagonalSegmentRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LengthOfLongestVShapedDiagonalSegmentTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2, 1, 2, 2),
                    intArrayOf(2, 0, 2, 2, 0),
                    intArrayOf(2, 0, 1, 1, 0),
                    intArrayOf(1, 0, 2, 2, 2),
                    intArrayOf(2, 0, 0, 2, 2)
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 2, 2, 2, 2),
                    intArrayOf(2, 0, 2, 2, 0),
                    intArrayOf(2, 0, 1, 1, 0),
                    intArrayOf(1, 0, 2, 2, 2),
                    intArrayOf(2, 0, 0, 2, 2)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 2, 2, 2),
                    intArrayOf(2, 2, 2, 2, 0),
                    intArrayOf(2, 0, 0, 0, 0),
                    intArrayOf(0, 0, 2, 2, 2),
                    intArrayOf(2, 0, 0, 2, 0)
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                1
            )
        )
    }

    @Nested
    inner class LengthOfLongestVShapedDiagonalSegmentRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest V-shaped diagonal segment`(grid: Array<IntArray>, expected: Int) {
            LengthOfLongestVShapedDiagonalSegmentRev1().test(grid, expected)
        }
    }
}

private fun LengthOfLongestVShapedDiagonalSegment.test(grid: Array<IntArray>, expected: Int) {
    val actual = lenOfVDiagonal(grid)
    assertEquals(expected, actual)
}
