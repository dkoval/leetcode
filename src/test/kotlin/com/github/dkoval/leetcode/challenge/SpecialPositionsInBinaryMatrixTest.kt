package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpecialPositionsInBinaryMatrix.SpecialPositionsInBinaryMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SpecialPositionsInBinaryMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 0)
                ),
                1
            ),
            arguments(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1)
                ),
                3
            )
        )
    }

    @Nested
    inner class SpecialPositionsInBinaryMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of special positions in the grid`(
            mat: Array<IntArray>,
            expected: Int
        ) {
            SpecialPositionsInBinaryMatrixRev1().test(mat, expected)
        }
    }
}

private fun SpecialPositionsInBinaryMatrix.test(mat: Array<IntArray>, expected: Int) {
    val actual = numSpecial(mat)
    assertEquals(expected, actual)
}
