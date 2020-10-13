package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.GuessNumberHigherOrLower2.GuessNumberHigherOrLower2BruteForce
import com.github.dkoval.leetcode.mock.GuessNumberHigherOrLower2.GuessNumberHigherOrLower2TopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GuessNumberHigherOrLower2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 16),
            Arguments.of(1, 0),
            Arguments.of(2, 1)
        )
    }

    @Nested
    inner class GuessNumberHigherOrLower2BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return minimum amount of money you need to guarantee a win regardless picked number`(
            n: Int,
            expected: Int
        ) {
            GuessNumberHigherOrLower2BruteForce().test(n, expected)
        }
    }

    @Nested
    inner class GuessNumberHigherOrLower2TopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should  return minimum amount of money you need to guarantee a win regardless picked number`(
            n: Int,
            expected: Int
        ) {
            GuessNumberHigherOrLower2TopDown()
                .test(n, expected)
        }
    }

    private fun GuessNumberHigherOrLower2.test(n: Int, expected: Int) {
        val actual = getMoneyAmount(n)
        assertEquals(expected, actual)
    }
}