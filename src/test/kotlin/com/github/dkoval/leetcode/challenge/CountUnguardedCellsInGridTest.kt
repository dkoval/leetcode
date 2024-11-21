package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountUnguardedCellsInGrid.CountUnguardedCellsInGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountUnguardedCellsInGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                6,
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 3)
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 2),
                    intArrayOf(1, 4)
                ),
                7
            ),
            Arguments.of(
                3,
                3,
                arrayOf(
                    intArrayOf(1, 1)
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(2, 1),
                    intArrayOf(1, 2)
                ),
                4
            ),
            Arguments.of(
                3,
                4,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0),
                    intArrayOf(2, 1)
                ),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, 3),
                    intArrayOf(1, 0),
                    intArrayOf(2, 2),
                    intArrayOf(0, 2)
                ),
                1
            )
        )
    }

    @Nested
    inner class CountUnguardedCellsInGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unoccupied cells that are not guarded`(
            m: Int,
            n: Int,
            guards: Array<IntArray>,
            walls: Array<IntArray>,
            expected: Int
        ) {
            CountUnguardedCellsInGridRev1().test(m, n, guards, walls, expected)
        }
    }
}

private fun CountUnguardedCellsInGrid.test(
    m: Int,
    n: Int,
    guards: Array<IntArray>,
    walls: Array<IntArray>,
    expected: Int
) {
    val actual = countUnguarded(m, n, guards, walls)
    assertEquals(expected, actual)
}
