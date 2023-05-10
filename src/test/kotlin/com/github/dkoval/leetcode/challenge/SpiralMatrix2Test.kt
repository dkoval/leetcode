package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpiralMatrix2.SpiralMatrix2Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpiralMatrix2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                arrayOf(
                    intArrayOf(1)
                )
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(4, 3)
                )
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(8, 9, 4),
                    intArrayOf(7, 6, 5)
                )
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(12, 13, 14, 5),
                    intArrayOf(11, 16, 15, 6),
                    intArrayOf(10, 9, 8, 7)
                )
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 2, 3, 4, 5),
                    intArrayOf(16, 17, 18, 19, 6),
                    intArrayOf(15, 24, 25, 20, 7),
                    intArrayOf(14, 23, 22, 21, 8),
                    intArrayOf(13, 12, 11, 10, 9)
                )
            )
        )
    }

    @Nested
    inner class SpiralMatrix2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should generate an n x n matrix filled with elements from 1 to n^2 in spiral order`(
            n: Int,
            expected: Array<IntArray>
        ) {
            SpiralMatrix2Rev1().test(n, expected)
        }
    }
}

private fun SpiralMatrix2.test(n: Int, expected: Array<IntArray>) {
    val actual = generateMatrix(n)
    assertArrayEquals(expected, actual)
}
