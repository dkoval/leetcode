package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.KnightProbabilityInChessboard.KnightProbabilityInChessboardDPTopDown
import com.github.dkoval.leetcode.mock.KnightProbabilityInChessboard.KnightProbabilityInChessboardUsing2DArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KnightProbabilityInChessboardTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 2, 0, 0, 0.06250),
            Arguments.of(1, 0, 0, 0, 1.00000)
        )
    }

    @Nested
    inner class KnightProbabilityInChessboardUsing2DArrayTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the probability that the knight remains on the board after it has stopped moving`(
            n: Int,
            k: Int,
            row: Int,
            col: Int,
            expected: Double
        ) {
            KnightProbabilityInChessboardUsing2DArray().test(n, k, row, col, expected)
        }
    }

    @Nested
    inner class KnightProbabilityInChessboardDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the probability that the knight remains on the board after it has stopped moving`(
            n: Int,
            k: Int,
            row: Int,
            col: Int,
            expected: Double
        ) {
            KnightProbabilityInChessboardDPTopDown().test(n, k, row, col, expected)
        }
    }
}

private fun KnightProbabilityInChessboard.test(n: Int, k: Int, row: Int, col: Int, expected: Double) {
    val actual = knightProbability(n, k, row, col)
    assertEquals(expected, actual, 1E-6)
}
