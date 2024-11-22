package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FlipColumnsForMaximumNumberOfEqualRows.FlipColumnsForMaximumNumberOfEqualRowsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FlipColumnsForMaximumNumberOfEqualRowsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 1)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 0)
                ),
                2
            )
        )
    }

    @Nested
    inner class FlipColumnsForMaximumNumberOfEqualRowsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of rows that have all values equal after some number of flips`(
            matrix: Array<IntArray>,
            expected: Int
        ) {
            FlipColumnsForMaximumNumberOfEqualRowsRev1().test(matrix, expected)
        }
    }
}

private fun FlipColumnsForMaximumNumberOfEqualRowsRev1.test(matrix: Array<IntArray>, expected: Int) {
    val actual = maxEqualRowsAfterFlips(matrix)
    assertEquals(expected, actual)
}
