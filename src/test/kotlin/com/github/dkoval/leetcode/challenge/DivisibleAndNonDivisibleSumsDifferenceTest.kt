package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivisibleAndNonDivisibleSumsDifference.DivisibleAndNonDivisibleSumsDifferenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivisibleAndNonDivisibleSumsDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 3, 19),
            Arguments.of(5, 6, 15),
            Arguments.of(5, 1, -15)
        )
    }

    @Nested
    inner class DivisibleAndNonDivisibleSumsDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return divisible and non-divisible sums difference`(n: Int, m: Int, expected: Int) {
            DivisibleAndNonDivisibleSumsDifferenceRev1().test(n, m, expected)
        }
    }
}

private fun DivisibleAndNonDivisibleSumsDifference.test(n: Int, m: Int, expected: Int) {
    val actual = differenceOfSums(n, m)
    assertEquals(expected, actual)
}
