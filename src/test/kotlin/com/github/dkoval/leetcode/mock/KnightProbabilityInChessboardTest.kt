package com.github.dkoval.leetcode.mock

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

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 2, 0, 0, 0.0625)
        )
    }

    @Nested
    inner class KnightProbabilityInChessboardUsing2DArrayTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the probability that the knight remains on the board after it has stopped moving`(
            N: Int,
            K: Int,
            r: Int,
            c: Int,
            expected: Double
        ) {
            KnightProbabilityInChessboardUsing2DArray().test(N, K, r, c, expected)
        }
    }

    private fun KnightProbabilityInChessboard.test(N: Int, K: Int, r: Int, c: Int, expected: Double) {
        val actual = knightProbability(N, K, r, c)
        assertEquals(expected, actual, 1E-6)
    }
}