package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BagOfTokens.BagOfTokensGreedy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BagOfTokensTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(100),
                50,
                0
            ),
            Arguments.of(
                intArrayOf(100, 200),
                150,
                1
            ),
            Arguments.of(
                intArrayOf(100, 200, 300, 400),
                200,
                2
            )
        )
    }

    @Nested
    inner class BagOfTokensGreedyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest possible score you can achieve after playing any number of tokens`(
            tokens: IntArray,
            power: Int,
            expected: Int
        ) {
            BagOfTokensGreedy().test(tokens, power, expected)
        }
    }

    private fun BagOfTokens.test(tokens: IntArray, power: Int, expected: Int) {
        val actual = bagOfTokensScore(tokens, power)
        assertEquals(expected, actual)
    }
}