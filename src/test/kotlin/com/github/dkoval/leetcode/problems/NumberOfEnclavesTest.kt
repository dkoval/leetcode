package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.NumberOfEnclaves.NumberOfEnclavesDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfEnclavesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(0, 0, 0, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class NumberOfEnclavesDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of land cells for which we cannot walk off the boundary of the grid in any number of moves`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            NumberOfEnclavesDFS().test(grid, expected)
        }
    }

    private fun NumberOfEnclaves.test(grid: Array<IntArray>, expected: Int) {
        val actual = numEnclaves(grid)
        assertEquals(expected, actual)
    }
}