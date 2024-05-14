package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PathWithMaximumGold.PathWithMaximumGoldRev1
import com.github.dkoval.leetcode.challenge.PathWithMaximumGold.PathWithMaximumGoldRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PathWithMaximumGoldTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 6, 0),
                    intArrayOf(5, 8, 7),
                    intArrayOf(0, 9, 0)
                ),
                24
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 7),
                    intArrayOf(2, 0, 6),
                    intArrayOf(3, 4, 5),
                    intArrayOf(0, 3, 0)
                ),
                28
            )
        )
    }

    @Nested
    inner class PathWithMaximumGoldRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of gold you can collect`(grid: Array<IntArray>, expected: Int) {
            PathWithMaximumGoldRev1().test(grid, expected)
        }
    }

    @Nested
    inner class PathWithMaximumGoldRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of gold you can collect`(grid: Array<IntArray>, expected: Int) {
            PathWithMaximumGoldRev2().test(grid, expected)
        }
    }
}

private fun PathWithMaximumGold.test(grid: Array<IntArray>, expected: Int) {
    val actual = getMaximumGold(grid)
    assertEquals(expected, actual)
}
