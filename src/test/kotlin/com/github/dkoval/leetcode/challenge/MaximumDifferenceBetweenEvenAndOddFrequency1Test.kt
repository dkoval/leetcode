package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenEvenAndOddFrequency1.MaximumDifferenceBetweenEvenAndOddFrequency1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDifferenceBetweenEvenAndOddFrequency1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "aaaaabbc",
                3
            ),
            Arguments.of(
                "abcabcab",
                1
            )
        )
    }

    @Nested
    inner class MaximumDifferenceBetweenEvenAndOddFrequency1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference`(s: String, expected: Int) {
            MaximumDifferenceBetweenEvenAndOddFrequency1Rev1().test(s, expected)
        }
    }
}

private fun MaximumDifferenceBetweenEvenAndOddFrequency1.test(s: String, expected: Int) {
    val actual = maxDifference(s)
    assertEquals(expected, actual)
}
