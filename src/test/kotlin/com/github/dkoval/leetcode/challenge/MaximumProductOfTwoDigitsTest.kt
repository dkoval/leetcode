package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumProductOfTwoDigits.MaximumProductOfTwoDigitsRev1
import com.github.dkoval.leetcode.challenge.MaximumProductOfTwoDigits.MaximumProductOfTwoDigitsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumProductOfTwoDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(31, 3),
            Arguments.of(22, 4),
            Arguments.of(124, 8)
        )
    }

    @Nested
    inner class MaximumProductOfTwoDigitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the maximum product of any two digits in n`(n: Int, expected: Int) {
            MaximumProductOfTwoDigitsRev1().test(n, expected)
        }
    }

    @Nested
    inner class MaximumProductOfTwoDigitsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the maximum product of any two digits in n`(n: Int, expected: Int) {
            MaximumProductOfTwoDigitsRev2().test(n, expected)
        }
    }
}

private fun MaximumProductOfTwoDigits.test(n: Int, expected: Int) {
    val actual = maxProduct(n)
    assertEquals(expected, actual)
}
