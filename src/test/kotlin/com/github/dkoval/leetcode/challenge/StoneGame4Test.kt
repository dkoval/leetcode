package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StoneGame4.StoneGame4DPBottomUp
import com.github.dkoval.leetcode.challenge.StoneGame4.StoneGame4DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StoneGame4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(1, true),
            Arguments.of(2, false),
            Arguments.of(4, true),
            Arguments.of(7, false),
            Arguments.of(17, false)
        )
    }

    @Nested
    inner class StoneGame4DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if Alice wins the game, assuming both players play optimally`(
            n: Int,
            expected: Boolean
        ) {
            StoneGame4DPTopDown().test(n, expected)
        }
    }

    @Nested
    inner class StoneGame4DPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if Alice wins the game, assuming both players play optimally`(
            n: Int,
            expected: Boolean
        ) {
            StoneGame4DPBottomUp().test(n, expected)
        }
    }

    private fun StoneGame4.test(n: Int, expected: Boolean) {
        val actual = winnerSquareGame(n)
        assertEquals(expected, actual)
    }
}