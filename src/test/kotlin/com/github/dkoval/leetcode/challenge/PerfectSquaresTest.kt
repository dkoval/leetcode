package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PerfectSquares.PerfectSquaresDPBottomUp
import com.github.dkoval.leetcode.challenge.PerfectSquares.PerfectSquaresDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PerfectSquaresTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(12, 3), // 12 = 4 + 4 + 4
            Arguments.of(13, 2), // 13 = 4 + 9
            Arguments.of(20, 2) // 20 = 4 + 16
        )
    }

    @Nested
    inner class PerfectSquaresDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the least number of perfect square numbers which sum to n`(n: Int, expected: Int) {
            PerfectSquaresDPTopDown().test(n, expected)
        }
    }

    @Nested
    inner class PerfectSquaresDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the least number of perfect square numbers which sum to n`(n: Int, expected: Int) {
            PerfectSquaresDPBottomUp().test(n, expected)
        }
    }
}

private fun PerfectSquares.test(n: Int, expected: Int) {
    val actual = numSquares(n)
    assertEquals(expected, actual)
}
