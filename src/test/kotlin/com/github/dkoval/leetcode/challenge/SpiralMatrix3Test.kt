package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpiralMatrix3.SpiralMatrix3Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpiralMatrix3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                4,
                0,
                0,
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3)
                )
            ),
            Arguments.of(
                5,
                6,
                1,
                4,
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 5),
                    intArrayOf(2, 4),
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(0, 3),
                    intArrayOf(0, 4),
                    intArrayOf(0, 5),
                    intArrayOf(3, 5),
                    intArrayOf(3, 4),
                    intArrayOf(3, 3),
                    intArrayOf(3, 2),
                    intArrayOf(2, 2),
                    intArrayOf(1, 2),
                    intArrayOf(0, 2),
                    intArrayOf(4, 5),
                    intArrayOf(4, 4),
                    intArrayOf(4, 3),
                    intArrayOf(4, 2),
                    intArrayOf(4, 1),
                    intArrayOf(3, 1),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(0, 1),
                    intArrayOf(4, 0),
                    intArrayOf(3, 0),
                    intArrayOf(2, 0),
                    intArrayOf(1, 0),
                    intArrayOf(0, 0)
                )
            )
        )
    }

    @Nested
    inner class SpiralMatrix3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of coordinates representing the positions of the grid in the order you visited them`(
            rows: Int,
            cols: Int,
            rStart: Int,
            cStart: Int,
            expected: Array<IntArray>
        ) {
            SpiralMatrix3Rev1().test(rows, cols, rStart, cStart, expected)
        }
    }
}

private fun SpiralMatrix3.test(rows: Int, cols: Int, rStart: Int, cStart: Int, expected: Array<IntArray>) {
    val actual = spiralMatrixIII(rows, cols, rStart, cStart)
    assertArrayEquals(expected, actual)
}
