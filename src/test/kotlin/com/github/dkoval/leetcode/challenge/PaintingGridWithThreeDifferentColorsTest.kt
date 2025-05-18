package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PaintingGridWithThreeDifferentColors.PaintingGridWithThreeDifferentColorsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PaintingGridWithThreeDifferentColorsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1, 3),
            Arguments.of(1, 2, 6),
            Arguments.of(5, 5, 580986)
        )
    }

    @Nested
    inner class PaintingGridWithThreeDifferentColorsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways to color the grid with no two adjacent cells having the same color`(
            m: Int,
            n: Int,
            expected: Int
        ) {
            PaintingGridWithThreeDifferentColorsRev1().test(m, n, expected)
        }
    }
}

private fun PaintingGridWithThreeDifferentColors.test(m: Int, n: Int, expected: Int) {
    val actual = colorTheGrid(m, n)
    assertEquals(expected, actual)
}
