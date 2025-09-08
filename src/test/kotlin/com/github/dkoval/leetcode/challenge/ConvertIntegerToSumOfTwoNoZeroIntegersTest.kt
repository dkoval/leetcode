package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConvertIntegerToSumOfTwoNoZeroIntegers.ConvertIntegerToSumOfTwoNoZeroIntegersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConvertIntegerToSumOfTwoNoZeroIntegersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2),
            Arguments.of(11),
            Arguments.of(10000),
            Arguments.of(69)
        )
    }

    @Nested
    inner class ConvertIntegerToSumOfTwoNoZeroIntegersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return two integers such that they do not contain the digit zero in their decimal representation and sum up to n`(
            n: Int
        ) {
            ConvertIntegerToSumOfTwoNoZeroIntegersRev1().test(n)
        }
    }
}

private fun ConvertIntegerToSumOfTwoNoZeroIntegers.test(n: Int) {
    val actual = getNoZeroIntegers(n)
    // since there are multiple valid answers, we just check that the sum is correct
    assertAll(
        { assertEquals(actual.size, 2) },
        { assertEquals(actual[0] + actual[1], n) },
        { assertFalse(actual[0].toString().contains('0')) },
        { assertFalse(actual[1].toString().contains('0')) }
    )
}
