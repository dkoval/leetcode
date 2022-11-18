package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RectangleArea.RectangleAreaRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RectangleAreaTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                -3, 0, 3, 4, 0, -1, 9, 2,
                45
            ),
            Arguments.of(
                -2, -2, 2, 2, -2, -2, 2, 2,
                16
            )
        )
    }

    @Nested
    inner class RectangleAreaRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total area covered by the two rectangles`(
            ax1: Int,
            ay1: Int,
            ax2: Int,
            ay2: Int,
            bx1: Int,
            by1: Int,
            bx2: Int,
            by2: Int,
            expected: Int
        ) {
            RectangleAreaRev1().test(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2, expected)
        }
    }

    private fun RectangleArea.test(
        ax1: Int,
        ay1: Int,
        ax2: Int,
        ay2: Int,
        bx1: Int,
        by1: Int,
        bx2: Int,
        by2: Int,
        expected: Int
    ) {
        val actual = computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)
        assertEquals(expected, actual)
    }
}