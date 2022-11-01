package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.WhereWillBallFall.WhereWillBallFallRev1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WhereWillBallFallTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, -1, -1),
                    intArrayOf(1, 1, 1, -1, -1),
                    intArrayOf(-1, -1, -1, 1, 1),
                    intArrayOf(1, 1, 1, 1, -1),
                    intArrayOf(-1, -1, -1, -1, -1)
                ),
                intArrayOf(1, -1, -1, -1, -1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-1)
                ),
                intArrayOf(-1)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(-1, -1, -1, -1, -1, -1),
                    intArrayOf(1, 1, 1, 1, 1, 1),
                    intArrayOf(-1, -1, -1, -1, -1, -1)
                ),
                intArrayOf(0, 1, 2, 3, 4, -1)
            )
        )
    }

    @Nested
    inner class WhereWillBallFallRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the answer array`(grid: Array<IntArray>, expected: IntArray) {
            WhereWillBallFallRev1().test(grid, expected)
        }
    }

    private fun WhereWillBallFall.test(grid: Array<IntArray>, expected: IntArray) {
        val actual = findBall(grid)
        assertArrayEquals(expected, actual)
    }
}