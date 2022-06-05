package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NQueens2.NQueens2Rev1
import com.github.dkoval.leetcode.challenge.NQueens2.NQueens2Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NQueens2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 0),
            Arguments.of(3, 0),
            Arguments.of(4, 2),
            Arguments.of(5, 10)
        )
    }

    @Nested
    inner class NQueens2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct solutions to the n-queens puzzle`(n: Int, expected: Int) {
            NQueens2Rev1().test(n, expected)
        }
    }

    @Nested
    inner class NQueens2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct solutions to the n-queens puzzle`(n: Int, expected: Int) {
            NQueens2Rev2().test(n, expected)
        }
    }

    private fun NQueens2.test(n: Int, expected: Int) {
        val actual = totalNQueens(n)
        assertEquals(expected, actual)
    }
}