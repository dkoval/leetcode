package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestRectangleInHistogram.LargestRectangleInHistogramBruteForce
import com.github.dkoval.leetcode.challenge.LargestRectangleInHistogram.LargestRectangleInHistogramUsingStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestRectangleInHistogramTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(1),
                1
            ),
            Arguments.of(
                intArrayOf(2, 1, 5, 6, 2, 3),
                10
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 2),
                8
            ),
            Arguments.of(
                intArrayOf(2, 4),
                4
            )
        )
    }

    @Nested
    inner class LargestRectangleInHistogramBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find the area of largest rectangle in the histogram`(heights: IntArray, expected: Int) {
            val actual = LargestRectangleInHistogramBruteForce().largestRectangleArea(heights)
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class LargestRectangleInHistogramUsingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find the area of largest rectangle in the histogram`(heights: IntArray, expected: Int) {
            val actual = LargestRectangleInHistogramUsingStack().largestRectangleArea(heights)
            assertEquals(expected, actual)
        }
    }
}