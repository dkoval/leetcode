package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RectangleOverlap.RectangleOverlapRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RectangleOverlapTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 0, 2, 2),
                intArrayOf(1, 1, 3, 3),
                true
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 1),
                intArrayOf(1, 0, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 1),
                intArrayOf(2, 2, 3, 3),
                false
            )
        )
    }

    @Nested
    inner class RectangleOverlapRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if two rectangles overlap, otherwise false`(
            rec1: IntArray,
            rec2: IntArray,
            expected: Boolean
        ) {
            RectangleOverlapRev1().test(rec1, rec2, expected)
        }
    }
}

private fun RectangleOverlapRev1.test(rec1: IntArray, rec2: IntArray, expected: Boolean) {
    val actual = isRectangleOverlap(rec1, rec2)
    assertEquals(expected, actual)
}
