package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IncrementSubmatricesByOne.IncrementSubmatricesByOneRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IncrementSubmatricesByOneTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 1, 2, 2),
                    intArrayOf(0, 0, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 1, 1)
                )
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(0, 0, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                )
            )
        )
    }

    @Nested
    inner class IncrementSubmatricesByOneRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the matrix mat after performing every query`(
            n: Int,
            queries: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            IncrementSubmatricesByOneRev1().test(n, queries, expected)

        }
    }
}

private fun IncrementSubmatricesByOne.test(n: Int, queries: Array<IntArray>, expected: Array<IntArray>) {
    val actual = rangeAddQueries(n, queries)
    assertArrayEquals(expected, actual)
}
