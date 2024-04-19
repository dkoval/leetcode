package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.OutOfBoundaryPaths.OutOfBoundaryPathsDPBottomUpRev1
import com.github.dkoval.leetcode.challenge.OutOfBoundaryPaths.OutOfBoundaryPathsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class OutOfBoundaryPathsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 2, 2, 0, 0, 6),
            Arguments.of(1, 3, 3, 0, 1, 12),
            Arguments.of(8, 50, 23, 5, 26, 914783380)
        )
    }

    @Nested
    inner class OutOfBoundaryPathsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of paths to move the ball out of the grid boundary`(
            m: Int,
            n: Int,
            maxMove: Int,
            startRow: Int,
            startColumn: Int,
            expected: Int
        ) {
            OutOfBoundaryPathsDPTopDown().test(m, n, maxMove, startRow, startColumn, expected)
        }
    }

    @Nested
    inner class OutOfBoundaryPathsDPBottomUpRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of paths to move the ball out of the grid boundary`(
            m: Int,
            n: Int,
            maxMove: Int,
            startRow: Int,
            startColumn: Int,
            expected: Int
        ) {
            OutOfBoundaryPathsDPBottomUpRev1().test(m, n, maxMove, startRow, startColumn, expected)
        }
    }

    private fun OutOfBoundaryPaths.test(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int, expected: Int) {
        val actual = findPaths(m, n, maxMove, startRow, startColumn)
        assertEquals(expected, actual)
    }
}