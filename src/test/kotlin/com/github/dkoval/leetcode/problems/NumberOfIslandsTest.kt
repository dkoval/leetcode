package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.NumberOfIslands.NumberOfIslandBFS
import com.github.dkoval.leetcode.problems.NumberOfIslands.NumberOfIslandsDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfIslandsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('1','1','1','1','0'),
                    charArrayOf('1','1','0','1','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','0','0','0')
                ),
                1,
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','1','0','0'),
                    charArrayOf('0','0','0','1','1')
                ),
                3
            )
        )
    }

    @Nested
    inner class NumberOfIslandsDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of islands`(grid: Array<CharArray>, expected: Int) {
            NumberOfIslandsDFS().test(grid, expected)
        }
    }

    @Nested
    inner class NumberOfIslandsBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of islands`(grid: Array<CharArray>, expected: Int) {
            NumberOfIslandBFS().test(grid, expected)
        }
    }
}

private fun NumberOfIslands.test(grid: Array<CharArray>, expected: Int) {
    val actual = numIslands(grid)
    assertEquals(expected, actual)
}
