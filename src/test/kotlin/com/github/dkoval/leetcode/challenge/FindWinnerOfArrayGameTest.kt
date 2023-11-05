package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindWinnerOfArrayGame.FindWinnerOfArrayGameRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindWinnerOfArrayGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3, 5, 4, 6, 7),
                2,
                5
            ),
            Arguments.of(
                intArrayOf(3, 2, 1),
                10,
                3
            ),
            Arguments.of(
                intArrayOf(1, 11, 22, 33, 44, 55, 66, 77, 88, 99),
                1000000000,
                99
            )
        )
    }

    @Nested
    inner class FindWinnerOfArrayGameRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the integer which will win the game`(arr: IntArray, k: Int, expected: Int) {
            FindWinnerOfArrayGameRev1().test(arr, k, expected)
        }
    }
}

private fun FindWinnerOfArrayGame.test(arr: IntArray, k: Int, expected: Int) {
    val actual = getWinner(arr, k)
    assertEquals(expected, actual)
}
