package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumOddBinaryNumber.MaximumOddBinaryNumberRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumOddBinaryNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("010", "001"),
            Arguments.of("0101", "1001"),
            Arguments.of("01", "01"),
            Arguments.of("0111", "1101")
        )
    }

    @Nested
    inner class MaximumOddBinaryNumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a string representing the maximum odd binary number that can be created from s`(
            s: String,
            expected: String
        ) {
            MaximumOddBinaryNumberRev1().test(s, expected)
        }
    }
}

private fun MaximumOddBinaryNumber.test(s: String, expected: String) {
    val actual = maximumOddBinaryNumber(s)
    assertEquals(expected, actual)
}
