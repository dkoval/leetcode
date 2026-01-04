package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FourDivisors.FourDivisorsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FourDivisorsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(21, 4, 7),
                32
            ),
            Arguments.of(
                intArrayOf(21, 21),
                64
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                0
            )
        )
    }

    @Nested
    inner class FourDivisorsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return return the sum of divisors of the integers in that array that have exactly four divisors`(
            nums: IntArray,
            expected: Int
        ) {
            FourDivisorsRev1().test(nums, expected)
        }
    }
}

private fun FourDivisors.test(nums: IntArray, expected: Int) {
    val actual = sumFourDivisors(nums)
    assertEquals(expected, actual)
}
