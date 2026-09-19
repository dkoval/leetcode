package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CircleAndRectangleOverlapping.CircleAndRectangleOverlappingRev1
import com.github.dkoval.leetcode.challenge.CircleAndRectangleOverlapping.CircleAndRectangleOverlappingRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CircleAndRectangleOverlappingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1, 0, 0, 1, -1, -3, 1,
                true
            ),
            Arguments.of(
                1, 1, 1, 1, -3, 2, -1,
                false
            ),
            Arguments.of(
                1, 0, 0, -1, 0, 0, 1,
                true
            )
        )
    }

    @Nested
    inner class CircleAndRectangleOverlappingRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the circle and rectangle overlap, otherwise false`(
            radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int, expected: Boolean
        ) {
            CircleAndRectangleOverlappingRev1().test(radius, xCenter, yCenter, x1, y1, x2, y2, expected)
        }
    }

    @Nested
    inner class CircleAndRectangleOverlappingRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the circle and rectangle overlap, otherwise false`(
            radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int, expected: Boolean
        ) {
            CircleAndRectangleOverlappingRev2().test(radius, xCenter, yCenter, x1, y1, x2, y2, expected)
        }
    }
}

private fun CircleAndRectangleOverlapping.test(
    radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int, expected: Boolean
) {
    val actual = checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2)
    assertEquals(expected, actual)
}
