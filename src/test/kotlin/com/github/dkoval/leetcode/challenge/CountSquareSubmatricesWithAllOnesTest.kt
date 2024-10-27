package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSquareSubmatricesWithAllOnes.CountSquareSubmatricesWithAllOnesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSquareSubmatricesWithAllOnesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(0, 1, 1, 1)
                ),
                15
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 1, 0)
                ),
                7
            )
        )
    }

    @Nested
    inner class CountSquareSubmatricesWithAllOnesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count square submatrices with all ones`(matrix: Array<IntArray>, expected: Int) {
            CountSquareSubmatricesWithAllOnesRev1.test(matrix, expected)
        }
    }

    @Nested
    inner class CountSquareSubmatricesWithAllOnesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count square submatrices with all ones`(matrix: Array<IntArray>, expected: Int) {
            CountSquareSubmatricesWithAllOnesRev2().test(matrix, expected)
        }
    }
}

private fun CountSquareSubmatricesWithAllOnes.test(matrix: Array<IntArray>, expected: Int) {
    val actual = countSquares(matrix)
    assertEquals(expected, actual)
}
