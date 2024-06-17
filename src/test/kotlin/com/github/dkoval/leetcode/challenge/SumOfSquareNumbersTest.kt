package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SumOfSquareNumbers.SumOfSquareNumbersRev1
import com.github.dkoval.leetcode.challenge.SumOfSquareNumbers.SumOfSquareNumbersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SumOfSquareNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            // 1^2 + 2^2 = 5
            Arguments.of(5, true),
            // 2^2 + 2^2 = 4
            Arguments.of(4, true),
            Arguments.of(3, false),
            // 1^2 + 1^2 = 2
            Arguments.of(2, true),
            // 0^2 + 1^2 = 1
            Arguments.of(1, true),
            // 0^2 + 0^2 = 0
            Arguments.of(0, true),
            Arguments.of(Int.MAX_VALUE, false),
            Arguments.of(2147483600, true),
            Arguments.of(2147483646, false)
        )
    }

    @Nested
    inner class SumOfSquareNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should decide whether there are two integers a and b such that a^2 + b^2 = c`(c: Int, expected: Boolean) {
            SumOfSquareNumbersRev1().test(c, expected)
        }
    }

    @Nested
    inner class SumOfSquareNumbersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should decide whether there are two integers a and b such that a^2 + b^2 = c`(c: Int, expected: Boolean) {
            SumOfSquareNumbersRev2().test(c, expected)
        }
    }
}

private fun SumOfSquareNumbers.test(c: Int, expected: Boolean) {
    val actual = judgeSquareSum(c)
    assertEquals(expected, actual)
}