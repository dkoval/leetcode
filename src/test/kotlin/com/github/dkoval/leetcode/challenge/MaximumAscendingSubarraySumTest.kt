package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumAscendingSubarraySum.MaximumAscendingSubarraySumRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumAscendingSubarraySumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 20, 30, 5, 10, 50),
                65
            ),
            Arguments.of(
                intArrayOf(10, 20, 30, 40, 50),
                150
            ),
            Arguments.of(
                intArrayOf(12, 17, 15, 13, 10, 11, 12),
                33
            )
        )
    }

    @Nested
    inner class MaximumAscendingSubarraySumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the maximum possible sum of an ascending subarray`(nums: IntArray, expected: Int) {
            MaximumAscendingSubarraySumRev1().test(nums, expected)
        }
    }
}

private fun MaximumAscendingSubarraySum.test(nums: IntArray, expected: Int) {
    val actual = maxAscendingSum(nums)
    assertEquals(expected, actual)
}
