package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NQueens.NQueensRev1
import com.github.dkoval.leetcode.challenge.NQueens.NQueensRev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NQueensTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                listOf(
                    listOf("Q")
                )
            ),
            Arguments.of(
                4,
                listOf(
                    listOf(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q."
                    ),
                    listOf(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                    )
                )
            )
        )
    }

    @Nested
    inner class NQueensRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return all distinct solutions to the n-queens puzzle`(n: Int, expected: List<List<String>>) {
            NQueensRev1().test(n, expected)
        }
    }

    @Nested
    inner class NQueensRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return all distinct solutions to the n-queens puzzle`(n: Int, expected: List<List<String>>) {
            NQueensRev2().test(n, expected)
        }
    }

    private fun NQueens.test(n: Int, expected: List<List<String>>) {
        val actual = solveNQueens(n)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}