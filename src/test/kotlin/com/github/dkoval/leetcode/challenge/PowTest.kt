package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PowTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(0.0, 1, 0.0),
            Arguments.of(0.0, -1, 0.0),
            Arguments.of(0.0, 0, Double.NaN),
            Arguments.of(2.00000, 0, 1.00000),
            Arguments.of(2.00000, 10, 1024.00000),
            Arguments.of(2.10000, 3, 9.26100),
            Arguments.of(2.00000, -2, 0.25000),
            Arguments.of(2.00000, -2147483648, 0.00000)
        )
    }

    @Nested
    inner class PowRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should calculate x raised to the power n`(x: Double, n: Int, expected: Double) {
            PowRecursive.test(x, n, expected)
        }
    }

    @Nested
    inner class PowIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should calculate x raised to the power n`(x: Double, n: Int, expected: Double) {
            PowIter.test(x, n, expected)
        }
    }

    private fun Pow.test(x: Double, n: Int, expected: Double) {
        val actual = myPow(x, n)
        assertEquals(expected, actual, 1e-6)
    }
}