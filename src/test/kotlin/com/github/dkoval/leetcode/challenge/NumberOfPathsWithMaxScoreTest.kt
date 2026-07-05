package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfPathsWithMaxScore.NumberOfPathsWithMaxScoreRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class NumberOfPathsWithMaxScoreTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf("E11", "XXX", "11S"),
                intArrayOf(0, 0)
            ),
            Arguments.of(
                listOf("E12", "1X1", "21S"),
                intArrayOf(4, 2)
            ),
            Arguments.of(
                listOf("E11", "XXX", "11S"),
                intArrayOf(0, 0)
            ),
        )
    }

    @Nested
    inner class NumberOfPathsWithMaxScoreRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of paths with max score`(board: List<String>, expected: IntArray) {
            NumberOfPathsWithMaxScoreRev1().test(board, expected)
        }
    }
}

private fun NumberOfPathsWithMaxScore.test(board: List<String>, expected: IntArray) {
    val actual = pathsWithMaxScore(board)
    assertArrayEquals(expected, actual)
}
