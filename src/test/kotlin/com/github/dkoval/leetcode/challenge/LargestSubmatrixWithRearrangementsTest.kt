package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestSubmatrixWithRearrangements.LargestSubmatrixWithRearrangementsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestSubmatrixWithRearrangementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1)
                ),
                4
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1, 0, 1)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1)
                ),
                2
            )
        )
    }

    @Nested
    inner class LargestSubmatrixWithRearrangementsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally`(
            matrix: Array<IntArray>,
            expected: Int
        ) {
            LargestSubmatrixWithRearrangementsRev1().test(matrix, expected)
        }
    }
}

private fun LargestSubmatrixWithRearrangements.test(matrix: Array<IntArray>, expected: Int) {
    val actual = largestSubmatrix(matrix)
    assertEquals(expected, actual)
}
