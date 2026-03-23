package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNonNegativeProductInMatrix.MaximumNonNegativeProductInMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumNonNegativeProductInMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(-1, -2, -3),
                    intArrayOf(-2, -3, -3),
                    intArrayOf(-3, -3, -2)
                ),
                -1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, -2, 1),
                    intArrayOf(1, -2, 1),
                    intArrayOf(3, -4, 1)
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, -4)
                ),
                0
            )
        )
    }

    @Nested
    inner class MaximumNonNegativeProductInMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum non-negative product`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            MaximumNonNegativeProductInMatrixRev1().test(grid, expected)
        }
    }
}

fun MaximumNonNegativeProductInMatrix.test(grid: Array<IntArray>, expected: Int) {
    val actual = maxProductPath(grid)
    assertEquals(expected, actual)
}
