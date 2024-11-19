package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumSumOfDistinctSubarraysWithLengthK.MaximumSumOfDistinctSubarraysWithLengthKRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumSumOfDistinctSubarraysWithLengthKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 4, 2, 9, 9, 9),
                3,
                15L
            ),
            Arguments.of(
                intArrayOf(4, 4, 4),
                3,
                0L
            )
        )
    }

    @Nested
    inner class MaximumSumOfDistinctSubarraysWithLengthKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum subarray sum of all the subarrays that meet the conditions`(
            nums: IntArray,
            k: Int,
            expected: Long
        ) {
            MaximumSumOfDistinctSubarraysWithLengthKRev1().test(nums, k, expected)
        }
    }
}

private fun MaximumSumOfDistinctSubarraysWithLengthK.test(nums: IntArray, k: Int, expected: Long) {
    val actual = maximumSubarraySum(nums, k)
    assertEquals(expected, actual)
}
