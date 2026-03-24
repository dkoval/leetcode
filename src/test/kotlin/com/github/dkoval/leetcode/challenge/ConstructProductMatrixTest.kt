package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConstructProductMatrix.ConstructProductMatrixRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ConstructProductMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                ),
                arrayOf(
                    intArrayOf(24, 12),
                    intArrayOf(8, 6)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(12345),
                    intArrayOf(2),
                    intArrayOf(1)
                ),
                arrayOf(
                    intArrayOf(2),
                    intArrayOf(0),
                    intArrayOf(0)
                )
            )
        )
    }

    @Nested
    inner class ConstructProductMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the product matrix of grid`(
            grid: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            ConstructProductMatrixRev1().test(grid, expected)
        }
    }
}

private fun ConstructProductMatrix.test(grid: Array<IntArray>, expected: Array<IntArray>) {
    val actual = constructProductMatrix(grid)
    assertArrayEquals(expected, actual)
}
