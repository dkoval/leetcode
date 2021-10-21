package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MaximalSquare.MaximalSquareDPBottomUp
import com.github.dkoval.leetcode.problems.MaximalSquare.MaximalSquareDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximalSquareTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '1', '1', '1'),
                    charArrayOf('1', '1', '1', '1', '1'),
                    charArrayOf('1', '0', '0', '1', '0')
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0', '1'),
                    charArrayOf('1', '0')
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('0')
                ),
                0
            )
        )
    }

    @Nested
    inner class MaximalSquareDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest square containing only 1's and return its area`(
            matrix: Array<CharArray>,
            expected: Int
        ) {
            MaximalSquareDPTopDown().test(matrix, expected)
        }
    }

    @Nested
    inner class MaximalSquareDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest square containing only 1's and return its area`(
            matrix: Array<CharArray>,
            expected: Int
        ) {
            MaximalSquareDPBottomUp().test(matrix, expected)
        }
    }

    private fun MaximalSquare.test(matrix: Array<CharArray>, expected: Int) {
        val actual = maximalSquare(matrix)
        assertEquals(expected, actual)
    }
}