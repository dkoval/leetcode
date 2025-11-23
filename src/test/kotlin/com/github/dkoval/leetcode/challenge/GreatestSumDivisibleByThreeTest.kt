package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GreatestSumDivisibleByThree.GreatestSumDivisibleByThreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GreatestSumDivisibleByThreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 6, 5, 1, 8),
                18
            ),
            Arguments.of(
                intArrayOf(4),
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 4),
                12
            )
        )
    }

    @Nested
    inner class GreatestSumDivisibleByThreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the greatest sum of elements of nums such that the sum is divisible by three`(
            nums: IntArray,
            expected: Int
        ) {
            GreatestSumDivisibleByThreeRev1().test(nums, expected)
        }
    }
}

private fun GreatestSumDivisibleByThree.test(nums: IntArray, expected: Int) {
    val actual = maxSumDivThree(nums)
    assertEquals(expected, actual)
}
