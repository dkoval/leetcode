package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountWaysToBuildGoodStrings.CountWaysToBuildGoodStringsDPTopDownRev1
import com.github.dkoval.leetcode.challenge.CountWaysToBuildGoodStrings.CountWaysToBuildGoodStringsDPTopDownRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountWaysToBuildGoodStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 3, 1, 1, 8),
            Arguments.of(2, 3, 1, 2, 5)
        )
    }

    @Nested
    inner class CountWaysToBuildGoodStringsDPTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different good strings that can be constructed`(
            low: Int,
            high: Int,
            zero: Int,
            one: Int,
            expected: Int
        ) {
            CountWaysToBuildGoodStringsDPTopDownRev1().test(low, high, zero, one, expected)
        }
    }

    @Nested
    inner class CountWaysToBuildGoodStringsDPTopDownRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different good strings that can be constructed`(
            low: Int,
            high: Int,
            zero: Int,
            one: Int,
            expected: Int
        ) {
            CountWaysToBuildGoodStringsDPTopDownRev2().test(low, high, zero, one, expected)
        }
    }
}

private fun CountWaysToBuildGoodStrings.test(low: Int, high: Int, zero: Int, one: Int, expected: Int) {
    val actual = countGoodStrings(low, high, zero, one)
    assertEquals(expected, actual)
}
