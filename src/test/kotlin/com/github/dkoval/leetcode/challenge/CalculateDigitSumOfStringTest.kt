package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CalculateDigitSumOfString.CalculateDigitSumOfStringRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CalculateDigitSumOfStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments("11111222223", 3, "135"),
            arguments("00000000", 3, "000")
        )
    }

    @Nested
    inner class CalculateDigitSumOfStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return s after all rounds have been completed`(s: String, k: Int, expected: String) {
            CalculateDigitSumOfStringRev1().test(s, k, expected)
        }
    }
}

private fun CalculateDigitSumOfStringRev1.test(s: String, k: Int, expected: String) {
    val actual = digitSum(s, k)
    assertThat(actual).isEqualTo(expected)
}
