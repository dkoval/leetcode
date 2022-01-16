package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindWinnerOfCircularGame.FindWinnerOfCircularGameGoodEnough
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindWinnerOfCircularGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(5, 2, 3),
            Arguments.of(6, 5, 1),
            Arguments.of(9, 1, 9),
            Arguments.of(10, 1, 10),
            Arguments.of(1, 1, 1),
            Arguments.of(9, 2, 3),
            Arguments.of(9, 3, 1)
        )
    }

    @Nested
    inner class FindWinnerOfCircularGameGoodEnoughTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the winner of the game`(n: Int, k: Int, expected: Int) {
            FindWinnerOfCircularGameGoodEnough().test(n, k, expected)
        }
    }

    private fun FindWinnerOfCircularGame.test(n: Int, k: Int, expected: Int) {
        val actual = findTheWinner(n, k)
        assertEquals(expected, actual)
    }
}