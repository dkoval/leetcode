package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CalculateMoneyInLeetcodeBank.CalculateMoneyInLeetcodeBankRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CalculateMoneyInLeetcodeBankTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(4, 10),
            Arguments.of(10, 37),
            Arguments.of(20, 96)
        )
    }

    @Nested
    inner class CalculateMoneyInLeetcodeBankRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total amount of money he will have in the Leetcode bank at the end of the nth day`(
            n: Int,
            expected: Int
        ) {
            CalculateMoneyInLeetcodeBankRev1().test(n, expected)
        }
    }
}

private fun CalculateMoneyInLeetcodeBank.test(n: Int, expected: Int) {
    val actual = totalMoney(n)
    assertEquals(expected, actual)
}
