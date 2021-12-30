package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestIntegerDivisibleByK.SmallestIntegerDivisibleByKCheckingLoop
import com.github.dkoval.leetcode.challenge.SmallestIntegerDivisibleByK.SmallestIntegerDivisibleByKPigeonholePrinciple
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SmallestIntegerDivisibleByKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, -1),
            Arguments.of(3, 3)
        )
    }

    @Nested
    inner class SmallestIntegerDivisibleByKCheckingLoopTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1`(
            k: Int,
            expected: Int
        ) {
            SmallestIntegerDivisibleByKCheckingLoop().test(k, expected)
        }
    }

    @Nested
    inner class SmallestIntegerDivisibleByKPigeonholePrincipleTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1`(
            k: Int,
            expected: Int
        ) {
            SmallestIntegerDivisibleByKPigeonholePrinciple().test(k, expected)
        }
    }

    private fun SmallestIntegerDivisibleByK.test(k: Int, expected: Int) {
        val actual = smallestRepunitDivByK(k)
        assertEquals(expected, actual)
    }
}