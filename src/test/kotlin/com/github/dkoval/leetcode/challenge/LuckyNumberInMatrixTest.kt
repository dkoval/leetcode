package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LuckyNumberInMatrix.LuckyNumberInMatrixRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LuckyNumberInMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 7, 8),
                    intArrayOf(9, 11, 13),
                    intArrayOf(15, 16, 17)
                ),
                listOf(15)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 10, 4, 2),
                    intArrayOf(9, 3, 8, 7),
                    intArrayOf(15, 16, 17, 12)
                ),
                listOf(12)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 8),
                    intArrayOf(1, 2)
                ),
                listOf(7)
            )
        )
    }

    @Nested
    inner class LuckyNumberInMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all lucky numbers in the matrix in any order`(
            matrix: Array<IntArray>,
            expected: List<Int>
        ) {
            LuckyNumberInMatrixRev1().test(matrix, expected)
        }
    }
}

private fun LuckyNumberInMatrix.test(matrix: Array<IntArray>, expected: List<Int>) {
    val actual = luckyNumbers(matrix)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
