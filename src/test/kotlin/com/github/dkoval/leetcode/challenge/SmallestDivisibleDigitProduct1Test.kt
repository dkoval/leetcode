package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestDivisibleDigitProduct1.SmallestDivisibleDigitProduct1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestDivisibleDigitProduct1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 2, 10),
            Arguments.of(15, 3, 16)
        )
    }

    @Nested
    inner class SmallestDivisibleDigitProduct1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest number greater than or equal to n such that the product of its digits is divisible by t`(
            n: Int,
            t: Int,
            expected: Int
        ) {
            SmallestDivisibleDigitProduct1Rev1().test(n, t, expected)
        }
    }
}

private fun SmallestDivisibleDigitProduct1Rev1.test(n: Int, t: Int, expected: Int) {
    val actual = smallestNumber(n, t)
    assertEquals(expected, actual)
}
