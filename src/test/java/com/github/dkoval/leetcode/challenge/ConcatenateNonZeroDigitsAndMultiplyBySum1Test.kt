package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConcatenateNonZeroDigitsAndMultiplyBySum1.ConcatenateNonZeroDigitsAndMultiplyBySum1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ConcatenateNonZeroDigitsAndMultiplyBySum1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                10203004,
                12340L
            ),
            Arguments.of(
                1000,
                1
            ),
            Arguments.of(
                65463628,
                2618545120L
            )
        )
    }

    @Nested
    inner class ConcatenateNonZeroDigitsAndMultiplyBySum1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should concatenate non-zero digits and multiply by their sum`(n: Int, expected: Long) {
            ConcatenateNonZeroDigitsAndMultiplyBySum1Rev1().test(n, expected)
        }
    }
}

private fun ConcatenateNonZeroDigitsAndMultiplyBySum1Rev1.test(n: Int, expected: Long) {
    val actual = sumAndMultiply(n)
    assertEquals(expected, actual)
}