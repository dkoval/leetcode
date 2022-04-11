package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Shift2DGrid.Shift2DGridRev1
import com.github.dkoval.leetcode.challenge.Shift2DGrid.Shift2DGridRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Shift2DGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                1,
                listOf(
                    listOf(9, 1, 2),
                    listOf(3, 4, 5),
                    listOf(6, 7, 8)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 8, 1, 9),
                    intArrayOf(19, 7, 2, 5),
                    intArrayOf(4, 6, 11, 10),
                    intArrayOf(12, 0, 21, 13)
                ),
                4,
                listOf(
                    listOf(12, 0, 21, 13),
                    listOf(3, 8, 1, 9),
                    listOf(19, 7, 2, 5),
                    listOf(4, 6, 11, 10)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                9,
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5, 6),
                    listOf(7, 8, 9)
                )
            )
        )
    }

    @Nested
    inner class Shift2DGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the 2D grid after applying shift operation k times`(
            grid: Array<IntArray>,
            k: Int,
            expected: List<List<Int>>
        ) {
            Shift2DGridRev1().test(grid, k, expected)
        }
    }

    @Nested
    inner class Shift2DGridRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the 2D grid after applying shift operation k times`(
            grid: Array<IntArray>,
            k: Int,
            expected: List<List<Int>>
        ) {
            Shift2DGridRev2().test(grid, k, expected)
        }
    }

    private fun Shift2DGrid.test(grid: Array<IntArray>, k: Int, expected: List<List<Int>>) {
        val actual = shiftGrid(grid, k)
        assertEquals(expected, actual)
    }
}