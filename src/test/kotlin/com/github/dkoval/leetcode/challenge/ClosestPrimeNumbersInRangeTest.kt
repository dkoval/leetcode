package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ClosestPrimeNumbersInRange.ClosestPrimeNumbersInRangeRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ClosestPrimeNumbersInRangeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                10,
                19,
                intArrayOf(11, 13)
            ),
            Arguments.of(
                4,
                6,
                intArrayOf(-1, -1),
            ),
            Arguments.of(
                12854,
                130337,
                intArrayOf(12917, 12919)
            )
        )
    }

    @Nested
    inner class ClosestPrimeNumbersInRangeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the closest prime numbers in the range`(
            left: Int,
            right: Int,
            expected: IntArray
        ) {
            ClosestPrimeNumbersInRangeRev1().test(left, right, expected)
        }
    }
}

private fun ClosestPrimeNumbersInRange.test(left: Int, right: Int, expected: IntArray) {
    val actual = closestPrimes(left, right)
    assertArrayEquals(expected, actual)
}
