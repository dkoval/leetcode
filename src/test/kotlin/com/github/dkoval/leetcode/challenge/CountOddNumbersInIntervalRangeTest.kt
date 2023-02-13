package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountOddNumbersInIntervalRange.CountOddNumbersInIntervalRangeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountOddNumbersInIntervalRangeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 7, 3),
            Arguments.of(8, 10, 1),
            Arguments.of(1, 2, 1),
        )
    }

    @Nested
    inner class CountOddNumbersInIntervalRangeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the count of odd numbers between low and high`(low: Int, high: Int, expected: Int) {
            CountOddNumbersInIntervalRangeRev1().test(low, high, expected)
        }
    }
}

private fun CountOddNumbersInIntervalRange.test(low: Int, high: Int, expected: Int) {
    val actual = countOdds(low, high)
    assertEquals(expected, actual)
}
