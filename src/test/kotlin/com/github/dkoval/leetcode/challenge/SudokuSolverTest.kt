package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SudokuSolver.SudokuSolverRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SudokuSolverTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '6', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                ),
                arrayOf(
                    charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
                )
            )
        )
    }

    @Nested
    inner class SudokuSolverRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should solve the Sudoku puzzle by filling the empty cells`(
            board: Array<CharArray>,
            expected: Array<CharArray>
        ) {
            SudokuSolverRev1().test(board, expected)
        }
    }
}

private fun SudokuSolver.test(board: Array<CharArray>, expected: Array<CharArray>) {
    solveSudoku(board)
    assertArrayEquals(expected, board)
}
