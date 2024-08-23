package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FractionAdditionAndSubtraction.FractionAdditionAndSubtractionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FractionAdditionAndSubtractionTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("-1/2+1/2", "0/1"),
            Arguments.of("-1/2+1/2+1/3", "1/3"),
            Arguments.of("1/3-1/2", "-1/6")
        )
    }

    @Nested
    inner class FractionAdditionAndSubtractionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the calculation result in string format`(expression: String, expected: String) {
            FractionAdditionAndSubtractionRev1().test(expression, expected)
        }
    }
}

private fun FractionAdditionAndSubtraction.test(expression: String, expected: String) {
    val actual = fractionAddition(expression)
    assertEquals(expected, actual)
}
