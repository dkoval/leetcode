package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckDivisibilityByDigitSumAndProduct.CheckDivisibilityByDigitSumAndProductRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CheckDivisibilityByDigitSumAndProductTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                99,
                true
            ),
            Arguments.of(
                23,
                false
            )
        )
    }

    @Nested
    inner class CheckDivisibilityByDigitSumAndProductRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check divisibility`(n: Int, expected: Boolean) {
            CheckDivisibilityByDigitSumAndProductRev1().test(n, expected)
        }
    }
}

private fun CheckDivisibilityByDigitSumAndProduct.test(n: Int, expected: Boolean) {
    val actual = checkDivisibility(n)
    assertEquals(expected, actual)
}
