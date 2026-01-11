package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximalRectangle.MaximalRectangleRev1
import com.github.dkoval.leetcode.challenge.MaximalRectangle.MaximalRectangleRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximalRectangleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
                ),
                6
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0')
                ),
                0
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('1')
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0'),
                    charArrayOf('0')
                ),
                0
            )
        )
    }

    @Nested
    inner class MaximalRectangleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find the largest rectangle containing only 1's and return its area`(
            matrix: Array<CharArray>,
            expected: Int
        ) {
            MaximalRectangleRev1().test(matrix, expected)
        }
    }

    @Nested
    inner class MaximalRectangleRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `find the largest rectangle containing only 1's and return its area`(
            matrix: Array<CharArray>,
            expected: Int
        ) {
            MaximalRectangleRev2().test(matrix, expected)
        }
    }
}

private fun MaximalRectangle.test(matrix: Array<CharArray>, expected: Int) {
    val actual = maximalRectangle(matrix)
    assertEquals(expected, actual)
}
