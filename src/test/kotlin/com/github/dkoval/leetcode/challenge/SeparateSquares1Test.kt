package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SeparateSquares1.EPS
import com.github.dkoval.leetcode.challenge.SeparateSquares1.SeparateSquares1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SeparateSquares1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(2, 2, 1)
                ),
                1.00000
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 2),
                    intArrayOf(1, 1, 1)
                ),
                1.16667
            )
        )
    }

    @Nested
    inner class SeparateSquares1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `Find the minimum y-coordinate value of a horizontal line such that the total area of the squares above the line equals the total area of the squares below the line`(
            squares: Array<IntArray>,
            expected: Double
        ) {
            SeparateSquares1Rev1().test(squares, expected)
        }
    }
}

private fun SeparateSquares1.test(squares: Array<IntArray>, expected: Double) {
    val actual = separateSquares(squares)
    assertEquals(expected, actual, EPS)
}
